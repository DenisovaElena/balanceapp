DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (login, password,  balance) VALUES
  ('user1', '{noop}user1', 100),
  ('user2', '{noop}user2', 10);