INSERT INTO PUBLIC."user" (EMAIL, NAME, PW_HASH, REGISTRATION_STATE) VALUES ('linus@degel2.com', 'Linus', '$2a$10$IVO143LMfNc12ZAxUKx8MuNGRhcjJvr9sCAQYEO.2vfjnJ9zw4rja', 1);
INSERT INTO PUBLIC."user" (EMAIL, NAME, PW_HASH, REGISTRATION_STATE) VALUES ('aaron.ebnoether@gmx.de', 'Aaron', '$2a$10$0IIA4j.ld11oQMcamJptsOy2TfQswNR5/vbCpkxmQX8G7KvT55uYm', 1);
INSERT INTO PUBLIC."user" (EMAIL, NAME, PW_HASH, REGISTRATION_STATE) VALUES ('amar@bfh.ch', 'Amar', '$2a$10$0IIA4j.ld11oQMcamJptsOy2TfQswNR5/vbCpkxmQX8G7KvT55uYm', 1);


INSERT INTO PUBLIC."event" (DESCRIPTION, DISPLAY_NAME, DURATION, START_DATE_TIME, STATE, "owner_id") VALUES ('Basel Hack 23', '48 hours of intense innovation? Let''s collaborate, create, and turn ideas into reality. The hackathon is more than a competition – it''s a celebration of innovation, problem-solving, and teamwork. ', 2880, '2023-10-28 09:00:00.000000', 2, 1);
INSERT INTO PUBLIC."event" (DESCRIPTION, DISPLAY_NAME, DURATION, START_DATE_TIME, STATE, "owner_id") VALUES ('Vincis Birthday', 'Let''s Party guys!!!', 480, '2023-05-02 20:00:00.000000', 2, 2);
INSERT INTO PUBLIC."event" (DESCRIPTION, DISPLAY_NAME, DURATION, START_DATE_TIME, STATE, "owner_id") VALUES ('Linus''s Wedding <3 ', 'Let''s get married!', 480, '2023-12-02 17:00:00.000000', 2, 1);

INSERT INTO PUBLIC."participation" ("event_id", "user_id") VALUES (1, 1);
INSERT INTO PUBLIC."participation" ("event_id", "user_id") VALUES (1, 2);
INSERT INTO PUBLIC."participation" ("event_id", "user_id") VALUES (1, 3);

INSERT INTO PUBLIC."participation" ("event_id", "user_id") VALUES (2, 1);
INSERT INTO PUBLIC."participation" ("event_id", "user_id") VALUES (2, 2);

INSERT INTO PUBLIC."participation" ("event_id", "user_id") VALUES (3, 1);
INSERT INTO PUBLIC."participation" ("event_id", "user_id") VALUES (3, 2);
INSERT INTO PUBLIC."participation" ("event_id", "user_id") VALUES (3, 3);

INSERT INTO PUBLIC."media" (TIME, CREATOR_ID, EVENT_ID, HASH) VALUES ('2023-10-28 09:30:19.184116', 1, 1, 'jU4e1YowzBfnxnQDrYSUy7RlXn88_zrNMnASeXGzmHE=');
INSERT INTO PUBLIC."media" (TIME, CREATOR_ID, EVENT_ID, HASH) VALUES ('2023-10-28 11:02:19.184116', 2, 1, 'Gb8kiODD13iF0J5RdAbEsr-6RmjfeuOVQmyIilRVgTI=');
INSERT INTO PUBLIC."media" (TIME, CREATOR_ID, EVENT_ID, HASH) VALUES ('2023-10-28 11:33:19.184116', 1, 1, '4zkmtAqebY4Gw8JcSlCuAv8dl6V-8TIQY2IZGgTMlGw=');
INSERT INTO PUBLIC."media" (TIME, CREATOR_ID, EVENT_ID, HASH) VALUES ('2023-10-28 12:16:19.184116', 1, 1, 'BcnNajnr-AbYqE1MTasoDIMGxQcu60bY47bHrnxXvZ0=');
INSERT INTO PUBLIC."media" (TIME, CREATOR_ID, EVENT_ID, HASH) VALUES ('2023-10-28 12:50:40.184116', 3, 1, '1aTCYxJtxZB6fwt2fCShkeIAZoRf94yXP8QSbWlQpY0=');
INSERT INTO PUBLIC."media" (TIME, CREATOR_ID, EVENT_ID, HASH) VALUES ('2023-10-28 14:58:19.184116', 3, 1, '1-p7J-P-M0lIWcNUUvy0eu9XT3AdxaWLisIHWd4XTeU=');
INSERT INTO PUBLIC."media" (TIME, CREATOR_ID, EVENT_ID, HASH) VALUES ('2023-10-28 19:41:19.184116', 3, 1, 'FKyEJLz2NPqPY9s3nJYbKqDvVKjLuDFwu9cKL992Qcw=');
INSERT INTO PUBLIC."media" (TIME, CREATOR_ID, EVENT_ID, HASH) VALUES ('2023-10-28 19:47:19.184116', 3, 1, 'SX5WZcLRdoxE0-kLQwWL5cFpn70zYzEKvYLWQCbZjXQ=');
INSERT INTO PUBLIC."media" (TIME, CREATOR_ID, EVENT_ID, HASH) VALUES ('2023-10-28 23:38:19.184116', 1, 1, 'Zal5G4EQjbCis4iQsRQhjYI7ZSzyKxiCu6_35aeyKog=');


INSERT INTO PUBLIC."comment" (CONTENT, DATE_TIME, "media_item_id", "owner_id") VALUES ('Sooo Tasty!!!', '2023-10-29 11:03:06.023666', 5, 1);
INSERT INTO PUBLIC."comment" (CONTENT, DATE_TIME, "media_item_id", "owner_id") VALUES ('Yummy <3', '2023-10-29 11:03:06.023666', 5, 2);
INSERT INTO PUBLIC."comment" (CONTENT, DATE_TIME, "media_item_id", "owner_id") VALUES ('Cool Picture', '2023-10-29 11:08:02.648643', 1, 3);
INSERT INTO PUBLIC."comment" (CONTENT, DATE_TIME, "media_item_id", "owner_id") VALUES ('👍', '2023-10-29 11:08:02.648643', 1, 2);



