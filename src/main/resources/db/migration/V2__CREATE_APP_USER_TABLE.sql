CREATE TABLE app_user (
    user_id                     UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name                  VARCHAR(255),
    last_name                   VARCHAR(255),
    email                       VARCHAR(255) UNIQUE,
    password                    VARCHAR(255),
    phone_number                BIGINT UNIQUE,
    phone_number_ext            SMALLINT,
    app_id                      UUID,
    FOREIGN KEY(app_id) REFERENCES application
);

INSERT INTO app_user(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PHONE_NUMBER, PHONE_NUMBER_EXT)
        VALUES ('Chaitanya', 'Chunduri', 'chaitanyach@gmail.com', 'random', 9885531710, 91);
