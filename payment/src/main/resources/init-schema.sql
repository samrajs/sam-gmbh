DROP SCHEMA IF EXISTS payment CASCADE;

CREATE SCHEMA payment;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS payment_status;

CREATE TYPE payment_status AS ENUM ('COMPLETED', 'CANCELLED', 'DECLINED');

DROP TABLE IF EXISTS "payment".payments CASCADE;

CREATE TABLE "payment".payments
(
    id uuid NOT NULL,
    customer_id uuid NOT NULL,
    order_id uuid NOT NULL,
    order_amount numeric(10,2) NOT NULL,
    status payment_status NOT NULL,
    created_at timestamp,
    created_by character varying COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp,
    updated_by character varying COLLATE pg_catalog."default",
    CONSTRAINT payments_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "payment".credit_entry CASCADE;

CREATE TABLE "payment".credit_entry
(
    customer_id uuid NOT NULL,
    balance numeric(10,2) NOT NULL,
    created_at timestamp,
    created_by character varying COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp,
    updated_by character varying COLLATE pg_catalog."default",    
    CONSTRAINT credit_entry_pkey PRIMARY KEY (customer_id)
);

DROP TYPE IF EXISTS transaction_type;

CREATE TYPE transaction_type AS ENUM ('DEBIT', 'CREDIT');

DROP TABLE IF EXISTS "payment".credit_history CASCADE;

CREATE TABLE "payment".credit_history
(
    id uuid NOT NULL,
    customer_id uuid NOT NULL,
    amount numeric(10,2) NOT NULL,
    type transaction_type NOT NULL,
    CONSTRAINT credit_history_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "payment".outbox CASCADE;

CREATE TABLE "payment".outbox
(
    id uuid NOT NULL,
    payload jsonb NOT NULL,
    aggregate_type character varying COLLATE pg_catalog."default" NOT NULL,
    aggregate_id uuid NOT NULL,
    tracingspancontext character varying COLLATE pg_catalog."default",
    CONSTRAINT product_outbox_pkey PRIMARY KEY (id)
);