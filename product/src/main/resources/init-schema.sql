DROP SCHEMA IF EXISTS "product" CASCADE;

CREATE SCHEMA "product";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS product_status;
CREATE TYPE product_status AS ENUM ('PENDING', 'AVAILABLE', 'PHASING_OUT', 'NOT_AVAILABLE');

DROP TYPE IF EXISTS product_category;
CREATE TYPE product_category AS ENUM ('ELECTRONIC', 'SPORTS', 'HOME_APPLIANCES');

DROP TABLE IF EXISTS "product".products CASCADE;

CREATE TABLE "product".products
(
    id uuid NOT NULL,
    product_name character varying COLLATE pg_catalog."default" NOT NULL,
    product_description character varying COLLATE pg_catalog."default" NOT NULL,
    price numeric(10,2) NOT NULL,
    product_status product_status NOT NULL,
    category product_category NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (id)
);

CREATE TABLE "product".outbox
(
    id uuid NOT NULL,
    payload jsonb NOT NULL,
    aggregate_type character varying COLLATE pg_catalog."default" NOT NULL,
    aggregate_id uuid NOT NULL,
    CONSTRAINT product_outbox_pkey PRIMARY KEY (id)
);