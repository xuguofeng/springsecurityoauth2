package org.net5ijy.oauth2.provider.code;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.redis.JdkSerializationStrategy;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStoreSerializationStrategy;

/**
 * Implementation of authorization code services that stores the codes and authentication in redis
 * database.
 *
 * @author xuguofeng
 * @date 2019/8/30 8:30
 */
@SuppressWarnings({"unused"})
public class RedisAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {

  private final static String AUTHORIZATION_CODE = "authorization_code:";

  private final RedisConnectionFactory connectionFactory;

  private RedisTokenStoreSerializationStrategy serializationStrategy = new JdkSerializationStrategy();

  public void setSerializationStrategy(RedisTokenStoreSerializationStrategy serializationStrategy) {
    this.serializationStrategy = serializationStrategy;
  }

  private RedisConnection getConnection() {
    return connectionFactory.getConnection();
  }

  public RedisAuthorizationCodeServices(
      RedisConnectionFactory connectionFactory) {
    this.connectionFactory = connectionFactory;
  }

  private byte[] serialize(Object object) {
    return serializationStrategy.serialize(object);
  }

  private byte[] serialize(String string) {
    return serializationStrategy.serialize(string);
  }

  private String deserializeString(byte[] bytes) {
    return serializationStrategy.deserializeString(bytes);
  }

  private byte[] serializeKey(String object) {
    return serialize(object);
  }

  private OAuth2Authentication deserializeAuthentication(byte[] bytes) {
    return serializationStrategy.deserialize(bytes, OAuth2Authentication.class);
  }

  @Override
  protected void store(String code, OAuth2Authentication authentication) {

    byte[] serializedAuth = serialize(authentication);
    byte[] key = serializeKey(AUTHORIZATION_CODE + code);

    RedisConnection conn = getConnection();

    try {
      conn.openPipeline();
      conn.set(key, serializedAuth);
      conn.closePipeline();
    } finally {
      conn.close();
    }
  }

  @Override
  protected OAuth2Authentication remove(String code) {

    byte[] key = serializeKey(AUTHORIZATION_CODE + code);

    OAuth2Authentication authentication;

    RedisConnection conn = getConnection();

    try {

      byte[] bytes = conn.get(key);

      authentication = deserializeAuthentication(bytes);

      if (authentication != null) {
        conn.del(key);
      }

    } catch (EmptyResultDataAccessException e) {
      return null;
    } finally {
      conn.close();
    }

    return authentication;
  }
}
