-- Table: public.accounts

-- DROP TABLE public.accounts;

CREATE TABLE public.accounts
(
  nick text NOT NULL,
  type text NOT NULL,
  password text NOT NULL,
  CONSTRAINT accounts_pkey PRIMARY KEY (nick)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.accounts
  OWNER TO queststore;
