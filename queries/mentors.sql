-- Table: public.mentors

-- DROP TABLE public.mentors;

CREATE TABLE public.mentors
(
  user_id integer NOT NULL,
  name text,
  surname text,
  email text,
  class_id integer,
  CONSTRAINT class_id_fkey FOREIGN KEY (class_id)
      REFERENCES public.classes (class_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_id_fkey FOREIGN KEY (user_id)
      REFERENCES public.accounts (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.mentors
  OWNER TO queststore;
