CREATE TABLE application (
    app_id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    app_name                VARCHAR(255),
    app_desc                TEXT
);

CREATE TABLE app_features (
  feature_id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  feature_name        VARCHAR(50),
  app_id              UUID,
  FOREIGN KEY(app_id) REFERENCES application,
  UNIQUE(app_id, feature_name)
);

CREATE TABLE app_roles (
    role_id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    role_name       VARCHAR(50),
    app_id          UUID,
    FOREIGN KEY(app_id) REFERENCES application,
    UNIQUE(app_id, role_name)
)

