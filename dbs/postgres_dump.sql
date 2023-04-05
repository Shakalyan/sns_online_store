--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3
-- Dumped by pg_dump version 14.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: employee; Type: TABLE; Schema: public; Owner: shakalyan
--

CREATE TABLE public.employee (
    id integer NOT NULL,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    email character varying(255),
    phone_number character varying(11),
    role character varying(255) NOT NULL
);


ALTER TABLE public.employee OWNER TO shakalyan;

--
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: shakalyan
--

CREATE SEQUENCE public.employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_id_seq OWNER TO shakalyan;

--
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: shakalyan
--

ALTER SEQUENCE public.employee_id_seq OWNED BY public.employee.id;


--
-- Name: employee id; Type: DEFAULT; Schema: public; Owner: shakalyan
--

ALTER TABLE ONLY public.employee ALTER COLUMN id SET DEFAULT nextval('public.employee_id_seq'::regclass);


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: shakalyan
--

COPY public.employee (id, username, password, name, email, phone_number, role) FROM stdin;
1	test1	$2a$10$b1vPgbQ9.nYmv65KqVvNOuAdVNoV0861IOnO3XmZR2H/yhmA0H2Iy	Тест Тестович	test@gmail.com	9999	ADMIN
2	test2	$2a$10$SWAo35iRBcP9oLQAA43rtOBAQRFFUPoO468wbOkfq2bPuuGobyTPK	Тест Тестович	test@gmail.com	9999	MANAGER
\.


--
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: shakalyan
--

SELECT pg_catalog.setval('public.employee_id_seq', 2, true);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: shakalyan
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: employee employee_username_key; Type: CONSTRAINT; Schema: public; Owner: shakalyan
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_username_key UNIQUE (username);


--
-- PostgreSQL database dump complete
--

