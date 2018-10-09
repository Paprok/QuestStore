-- Table: queststore.accounts

-- DROP TABLE queststore.accounts;

CREATE TABLE queststore.accounts
(
  nick text NOT NULL,
  type text NOT NULL,
  password text NOT NULL,
  CONSTRAINT accounts_pkey PRIMARY KEY (nick)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE queststore.accounts
  OWNER TO queststore;
