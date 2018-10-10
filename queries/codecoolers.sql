-- Table: public.codecoolers

DROP TABLE public.codecoolers;

CREATE TABLE public.codecoolers
(
  nick text NOT NULL,
  balance integer,
  level integer,
  earned integer,
  CONSTRAINT codecoolers_nick_fkey FOREIGN KEY (nick)
      REFERENCES public.accounts (nick) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.codecoolers
  OWNER TO queststore;
