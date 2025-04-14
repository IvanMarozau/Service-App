CREATE TABLE InternalUser
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    email       VARCHAR(255) NOT NULL UNIQUE,
    role        VARCHAR(255) NOT NULL,
    total_score INT          NOT NULL,
    rev_count   INT          NOT NULL,
    balance     INT,
    expire_date DATE
);

CREATE TABLE EnumServiceType
(
    id   INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE EnumServiceSubType
(
    id              INTEGER PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    service_type_id INTEGER      NOT NULL,
    FOREIGN KEY (service_type_id) REFERENCES EnumServiceType (id)
);

CREATE TABLE TicketStatus
(
    code  VARCHAR(255) PRIMARY KEY,
    value VARCHAR(255) NOT NULL
);

CREATE TABLE Ticket
(
    id                  UUID PRIMARY KEY,
    description         VARCHAR(500),
    status_code         VARCHAR(255)                        NOT NULL,
    author_id           UUID                                NOT NULL,
    service_sub_type_id INTEGER                             NOT NULL,
    budget              INT,
    finish_TIMESTAMP    TIMESTAMP                           NOT NULL,
    creation_TIMESTAMP  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    location            VARCHAR(255)                        NOT NULL,
    last_notification_date DATE                             NULL,
    tasker_id           UUID                                NOT NULL,
    FOREIGN KEY (author_id) REFERENCES InternalUser (id),
    FOREIGN KEY (tasker_id) REFERENCES InternalUser (id),
    FOREIGN KEY (status_code) REFERENCES TicketStatus (code),
    FOREIGN KEY (service_sub_type_id) REFERENCES EnumServiceSubType (id)
);

CREATE TABLE Qualification
(
    id              UUID PRIMARY KEY,
    service_type_id INTEGER NOT NULL,
    user_id         UUID    NOT NULL,
    FOREIGN KEY (service_type_id) REFERENCES EnumServiceType (id),
    FOREIGN KEY (user_id) REFERENCES InternalUser (id)
);

CREATE TABLE ResponseStatus
(
    code  VARCHAR(255) PRIMARY KEY,
    value VARCHAR(255) NOT NULL
);

CREATE TABLE Response
(
    id                     UUID PRIMARY KEY,
    tasker_id              UUID         NOT NULL,
    ticket_id              UUID         NOT NULL,
    budget                 INT          NOT NULL,
    description            VARCHAR(500),
    finish_TIMESTAMP       TIMESTAMP    NOT NULL,
    update_TIMESTAMP       TIMESTAMP,
    response_status_code   VARCHAR(255) NOT NULL,
    FOREIGN KEY (tasker_id) REFERENCES InternalUser (id),
    FOREIGN KEY (ticket_id) REFERENCES Ticket (id),
    FOREIGN KEY (response_status_code) REFERENCES ResponseStatus (code)
);

CREATE TABLE Packages
(
    type        VARCHAR(255) PRIMARY KEY NOT NULL,
    value       FLOAT          NOT NULL,
    active_per   INT          NOT NULL,
    price       FLOAT       not null
);
INSERT INTO TicketStatus (code, value)
VALUES ('O', 'Open'),
       ('P', 'In progress'),
       ('C', 'Close');

INSERT INTO ResponseStatus (code, value)
VALUES ('O', 'Open'),
       ('A', 'Accepted'),
       ('D', 'Denied'),
       ('F', 'Finished');

INSERT INTO EnumServiceType (id, name)
VALUES (1, 'Moving'),
       (2, 'Cleaning'),
       (3, 'Outdoor Help');

INSERT INTO EnumServiceSubType (id, name, service_type_id)
VALUES (1, 'Trash &amp; Furniture Removal', 1),
       (2, 'Heavy Lifting &amp; Loading', 1),
       (3, 'Apartment Move In/Out', 1),
       (4, 'Party Clean Up', 2),
       (5, 'Deep clean', 2),
       (6, 'Garage Cleaning', 2),
       (7, 'Yard Work', 3),
       (8, 'Landscaping Help', 3),
       (9, 'Gardening', 3);

INSERT INTO Packages(type, value, active_per, price)
VALUES ('small', 100.0, 1, 2.99),
       ('middle', 300, 3, 7.99),
       ('big', 1200.0, 12, 21.99);