--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.8
-- Dumped by pg_dump version 9.5.8

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: car; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE car (
    vin integer NOT NULL,
    sticker_price money NOT NULL,
    make character varying(70) NOT NULL,
    model character varying(70) NOT NULL,
    year integer NOT NULL,
    color character varying(70) NOT NULL,
    is_new boolean NOT NULL,
    is_sold boolean NOT NULL,
    min_price money NOT NULL,
    mileage integer NOT NULL
);


ALTER TABLE car OWNER TO p32001c;

--
-- Name: customer; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE customer (
    cus_id integer NOT NULL,
    name character varying(70) NOT NULL,
    ref_type character varying(70) NOT NULL,
    ref_origin character varying(70) NOT NULL
);


ALTER TABLE customer OWNER TO p32001c;

--
-- Name: customer_cus_id_seq; Type: SEQUENCE; Schema: public; Owner: p32001c
--

CREATE SEQUENCE customer_cus_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE customer_cus_id_seq OWNER TO p32001c;

--
-- Name: customer_cus_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: p32001c
--

ALTER SEQUENCE customer_cus_id_seq OWNED BY customer.cus_id;


--
-- Name: customization_options; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE customization_options (
    custom_id integer NOT NULL,
    custom_name character varying(70) NOT NULL,
    cost money NOT NULL
);


ALTER TABLE customization_options OWNER TO p32001c;

--
-- Name: customization_options_custom_id_seq; Type: SEQUENCE; Schema: public; Owner: p32001c
--

CREATE SEQUENCE customization_options_custom_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE customization_options_custom_id_seq OWNER TO p32001c;

--
-- Name: customization_options_custom_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: p32001c
--

ALTER SEQUENCE customization_options_custom_id_seq OWNED BY customization_options.custom_id;


--
-- Name: employee; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE employee (
    emp_id integer NOT NULL,
    emp_name character varying(70) NOT NULL,
    commission numeric(5,2) NOT NULL,
    CONSTRAINT value_is_percentage CHECK (((commission >= (0)::numeric) AND (commission < (100)::numeric)))
);


ALTER TABLE employee OWNER TO p32001c;

--
-- Name: employee_emp_id_seq; Type: SEQUENCE; Schema: public; Owner: p32001c
--

CREATE SEQUENCE employee_emp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE employee_emp_id_seq OWNER TO p32001c;

--
-- Name: employee_emp_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: p32001c
--

ALTER SEQUENCE employee_emp_id_seq OWNED BY employee.emp_id;


--
-- Name: features; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE features (
    feat_id integer NOT NULL,
    feat_name character varying(70) NOT NULL
);


ALTER TABLE features OWNER TO p32001c;

--
-- Name: features_feat_id_seq; Type: SEQUENCE; Schema: public; Owner: p32001c
--

CREATE SEQUENCE features_feat_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE features_feat_id_seq OWNER TO p32001c;

--
-- Name: features_feat_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: p32001c
--

ALTER SEQUENCE features_feat_id_seq OWNED BY features.feat_id;


--
-- Name: financing; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE financing (
    fin_id integer NOT NULL,
    amount money NOT NULL,
    type character varying(250) NOT NULL,
    name character varying(70) NOT NULL,
    addr character varying(100) NOT NULL
);


ALTER TABLE financing OWNER TO p32001c;

--
-- Name: financing_fin_id_seq; Type: SEQUENCE; Schema: public; Owner: p32001c
--

CREATE SEQUENCE financing_fin_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE financing_fin_id_seq OWNER TO p32001c;

--
-- Name: financing_fin_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: p32001c
--

ALTER SEQUENCE financing_fin_id_seq OWNED BY financing.fin_id;


--
-- Name: has_customization; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE has_customization (
    custom_id integer NOT NULL,
    sale_id integer NOT NULL
);


ALTER TABLE has_customization OWNER TO p32001c;

--
-- Name: has_features; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE has_features (
    feat_id integer NOT NULL,
    vin integer NOT NULL
);


ALTER TABLE has_features OWNER TO p32001c;

--
-- Name: payment; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE payment (
    payment_id integer NOT NULL,
    amount money NOT NULL,
    trade_id integer,
    fin_id integer
);


ALTER TABLE payment OWNER TO p32001c;

--
-- Name: payment_payment_id_seq; Type: SEQUENCE; Schema: public; Owner: p32001c
--

CREATE SEQUENCE payment_payment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE payment_payment_id_seq OWNER TO p32001c;

--
-- Name: payment_payment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: p32001c
--

ALTER SEQUENCE payment_payment_id_seq OWNED BY payment.payment_id;


--
-- Name: practice; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE practice (
    practice_id integer NOT NULL,
    practice_int integer NOT NULL
);


ALTER TABLE practice OWNER TO p32001c;

--
-- Name: practice_practice_id_seq; Type: SEQUENCE; Schema: public; Owner: p32001c
--

CREATE SEQUENCE practice_practice_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE practice_practice_id_seq OWNER TO p32001c;

--
-- Name: practice_practice_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: p32001c
--

ALTER SEQUENCE practice_practice_id_seq OWNED BY practice.practice_id;


--
-- Name: sale; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE sale (
    sale_id integer NOT NULL,
    is_approved boolean NOT NULL,
    price money NOT NULL,
    date date NOT NULL,
    emp_requested boolean NOT NULL,
    tax_rate numeric(5,2) NOT NULL,
    license_fee money NOT NULL,
    cus_id integer NOT NULL,
    vin integer NOT NULL,
    emp_id integer NOT NULL,
    payment_id integer NOT NULL,
    warranty_id integer NOT NULL,
    CONSTRAINT value_is_percentage CHECK (((tax_rate >= (0)::numeric) AND (tax_rate < (100)::numeric)))
);


ALTER TABLE sale OWNER TO p32001c;

--
-- Name: sale_sale_id_seq; Type: SEQUENCE; Schema: public; Owner: p32001c
--

CREATE SEQUENCE sale_sale_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sale_sale_id_seq OWNER TO p32001c;

--
-- Name: sale_sale_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: p32001c
--

ALTER SEQUENCE sale_sale_id_seq OWNED BY sale.sale_id;


--
-- Name: trade_in; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE trade_in (
    trade_id integer NOT NULL,
    vin integer NOT NULL,
    miles integer NOT NULL,
    condition character varying(250) NOT NULL,
    value money NOT NULL
);


ALTER TABLE trade_in OWNER TO p32001c;

--
-- Name: trade_in_trade_id_seq; Type: SEQUENCE; Schema: public; Owner: p32001c
--

CREATE SEQUENCE trade_in_trade_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE trade_in_trade_id_seq OWNER TO p32001c;

--
-- Name: trade_in_trade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: p32001c
--

ALTER SEQUENCE trade_in_trade_id_seq OWNED BY trade_in.trade_id;


--
-- Name: warranty; Type: TABLE; Schema: public; Owner: p32001c
--

CREATE TABLE warranty (
    warranty_id integer NOT NULL,
    type character varying(70) NOT NULL,
    cost money NOT NULL,
    duration integer NOT NULL,
    miles integer NOT NULL
);


ALTER TABLE warranty OWNER TO p32001c;

--
-- Name: warranty_warranty_id_seq; Type: SEQUENCE; Schema: public; Owner: p32001c
--

CREATE SEQUENCE warranty_warranty_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE warranty_warranty_id_seq OWNER TO p32001c;

--
-- Name: warranty_warranty_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: p32001c
--

ALTER SEQUENCE warranty_warranty_id_seq OWNED BY warranty.warranty_id;


--
-- Name: cus_id; Type: DEFAULT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY customer ALTER COLUMN cus_id SET DEFAULT nextval('customer_cus_id_seq'::regclass);


--
-- Name: custom_id; Type: DEFAULT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY customization_options ALTER COLUMN custom_id SET DEFAULT nextval('customization_options_custom_id_seq'::regclass);


--
-- Name: emp_id; Type: DEFAULT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY employee ALTER COLUMN emp_id SET DEFAULT nextval('employee_emp_id_seq'::regclass);


--
-- Name: feat_id; Type: DEFAULT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY features ALTER COLUMN feat_id SET DEFAULT nextval('features_feat_id_seq'::regclass);


--
-- Name: fin_id; Type: DEFAULT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY financing ALTER COLUMN fin_id SET DEFAULT nextval('financing_fin_id_seq'::regclass);


--
-- Name: payment_id; Type: DEFAULT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY payment ALTER COLUMN payment_id SET DEFAULT nextval('payment_payment_id_seq'::regclass);


--
-- Name: practice_id; Type: DEFAULT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY practice ALTER COLUMN practice_id SET DEFAULT nextval('practice_practice_id_seq'::regclass);


--
-- Name: sale_id; Type: DEFAULT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY sale ALTER COLUMN sale_id SET DEFAULT nextval('sale_sale_id_seq'::regclass);


--
-- Name: trade_id; Type: DEFAULT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY trade_in ALTER COLUMN trade_id SET DEFAULT nextval('trade_in_trade_id_seq'::regclass);


--
-- Name: warranty_id; Type: DEFAULT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY warranty ALTER COLUMN warranty_id SET DEFAULT nextval('warranty_warranty_id_seq'::regclass);


--
-- Data for Name: car; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) FROM stdin;
555555	$10,000.00	ford	fusion	2010	silver	t	t	$0.30	0
666666	$15,000.00	ford	focus	2016	black	t	t	$0.50	0
777777	$9,000.00	ford	mustang	2000	white	t	t	$0.10	0
980074	$15,089.00	Ford	mustang	1997	silver	t	f	$0.10	0
219033	$6,548.00	Ford	focus	1997	black	t	f	$0.30	0
704538	$11,701.00	Ford	fusion	1997	black	t	f	$0.00	0
507510	$15,683.00	Ford	taurus	1997	silver	t	f	$0.20	0
201538	$18,085.00	Ford	mustang	1998	silver	t	f	$0.00	0
402294	$19,950.00	Ford	focus	1998	silver	t	f	$0.30	0
814733	$14,779.00	Ford	fusion	1998	black	t	f	$0.30	0
377303	$8,412.00	Ford	taurus	1998	black	t	f	$0.20	0
723806	$10,100.00	Ford	mustang	1999	silver	t	f	$0.40	0
440371	$13,135.00	Ford	focus	1999	black	t	f	$0.30	0
907220	$5,384.00	Ford	fusion	1999	red	t	f	$0.00	0
970749	$6,108.00	Ford	taurus	1999	silver	t	f	$0.30	0
251751	$5,782.00	Ford	mustang	2000	red	t	f	$0.30	0
403009	$19,000.00	Ford	focus	2000	black	t	f	$0.10	0
594378	$11,522.00	Ford	fusion	2000	silver	t	f	$0.00	0
858889	$9,594.00	Ford	taurus	2000	silver	t	f	$0.10	0
834217	$14,289.00	Ford	mustang	2001	silver	t	f	$0.40	0
647444	$9,486.00	Ford	focus	2001	red	t	f	$0.00	0
925674	$13,049.00	Ford	fusion	2001	silver	t	f	$0.10	0
440990	$14,382.00	Ford	taurus	2001	silver	t	f	$0.20	0
446253	$6,699.00	Ford	mustang	2002	black	t	f	$0.00	0
716604	$14,200.00	Ford	focus	2002	red	t	f	$0.00	0
273198	$10,363.00	Ford	fusion	2002	black	t	f	$0.30	0
432479	$14,348.00	Ford	taurus	2002	silver	t	f	$0.40	0
511775	$6,484.00	Ford	mustang	2003	black	t	f	$0.40	0
351694	$7,669.00	Ford	focus	2003	red	t	f	$0.20	0
440496	$11,933.00	Ford	fusion	2003	black	t	f	$0.40	0
801678	$5,253.00	Ford	taurus	2003	black	t	f	$0.40	0
730153	$8,880.00	Ford	mustang	2004	black	t	f	$0.10	0
273179	$13,275.00	Ford	focus	2004	silver	t	f	$0.40	0
537388	$9,040.00	Ford	fusion	2004	black	t	f	$0.30	0
870317	$5,030.00	Ford	taurus	2004	black	t	f	$0.10	0
175765	$18,352.00	Ford	mustang	2005	red	t	f	$0.20	0
835030	$19,072.00	Ford	focus	2005	black	t	f	$0.30	0
694107	$5,112.00	Ford	fusion	2005	black	t	f	$0.30	0
194528	$19,677.00	Ford	taurus	2005	black	t	f	$0.30	0
335598	$16,225.00	Ford	mustang	2006	red	t	f	$0.10	0
978898	$6,011.00	Ford	focus	2006	silver	t	f	$0.20	0
315640	$15,037.00	Ford	fusion	2006	silver	t	f	$0.10	0
544745	$17,034.00	Ford	taurus	2006	silver	t	f	$0.20	0
252350	$18,314.00	Ford	mustang	2007	black	t	f	$0.30	0
783936	$9,523.00	Ford	focus	2007	red	t	f	$0.30	0
746142	$12,013.00	Ford	fusion	2007	silver	t	f	$0.40	0
228586	$15,299.00	Ford	taurus	2007	black	t	f	$0.00	0
410769	$12,401.00	Ford	mustang	2008	red	t	f	$0.40	0
849972	$10,462.00	Ford	focus	2008	silver	t	f	$0.40	0
247751	$19,135.00	Ford	fusion	2008	silver	t	f	$0.20	0
394950	$18,245.00	Ford	taurus	2008	red	t	f	$0.40	0
889071	$12,325.00	Ford	mustang	2009	red	t	f	$0.40	0
198720	$15,611.00	Ford	focus	2009	red	t	f	$0.00	0
436334	$17,290.00	Ford	fusion	2009	black	t	f	$0.10	0
245471	$10,945.00	Ford	taurus	2009	red	t	f	$0.20	0
113509	$18,357.00	Ford	mustang	2010	silver	t	f	$0.10	0
707159	$13,959.00	Ford	focus	2010	red	t	f	$0.20	0
480685	$11,602.00	Ford	fusion	2010	red	t	f	$0.10	0
896920	$19,508.00	Ford	taurus	2010	silver	t	f	$0.40	0
586651	$13,510.00	Ford	mustang	2011	black	t	f	$0.10	0
334186	$16,858.00	Ford	focus	2011	black	t	f	$0.30	0
805502	$5,664.00	Ford	fusion	2011	silver	t	f	$0.40	0
891442	$17,373.00	Ford	taurus	2011	black	t	f	$0.20	0
193182	$5,000.00	Ford	mustang	2012	silver	t	f	$0.20	0
590829	$12,250.00	Ford	focus	2012	red	t	f	$0.20	0
997437	$7,314.00	Ford	fusion	2012	silver	t	f	$0.20	0
898546	$14,146.00	Ford	taurus	2012	red	t	f	$0.40	0
675479	$8,945.00	Ford	mustang	2013	silver	t	f	$0.30	0
131794	$15,326.00	Ford	focus	2013	black	t	f	$0.20	0
989443	$5,958.00	Ford	fusion	2013	black	t	f	$0.10	0
356345	$11,898.00	Ford	taurus	2013	silver	t	f	$0.30	0
455409	$11,368.00	Ford	mustang	2014	red	t	f	$0.00	0
736556	$15,620.00	Ford	focus	2014	black	t	f	$0.10	0
251339	$5,682.00	Ford	fusion	2014	silver	t	f	$0.30	0
957929	$12,819.00	Ford	taurus	2014	black	t	f	$0.10	0
943990	$14,474.00	Ford	mustang	2015	silver	t	f	$0.40	0
550540	$6,602.00	Ford	focus	2015	black	t	f	$0.10	0
376592	$15,142.00	Ford	fusion	2015	red	t	f	$0.20	0
755846	$18,332.00	Ford	taurus	2015	red	t	f	$0.20	0
947729	$10,662.00	Ford	mustang	2016	red	t	f	$0.20	0
769382	$8,255.00	Ford	focus	2016	silver	t	f	$0.20	0
120588	$11,935.00	Ford	fusion	2016	black	t	f	$0.00	0
363186	$6,763.00	Ford	taurus	2016	red	t	f	$0.40	0
\.


--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY customer (cus_id, name, ref_type, ref_origin) FROM stdin;
1	Frank Murray	none	none
2	Jan Scott	web	facebook.com
3	Adrian Blake	mouth	Emma Peake
4	Emma Peake	web	cars.com
5	Adam Parr	tv ad	channel 3
\.


--
-- Name: customer_cus_id_seq; Type: SEQUENCE SET; Schema: public; Owner: p32001c
--

SELECT pg_catalog.setval('customer_cus_id_seq', 5, true);


--
-- Data for Name: customization_options; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY customization_options (custom_id, custom_name, cost) FROM stdin;
0	AC	$185.00
1	Heated Seats	$32.00
2	Power Windows	$471.00
3	Sunroof	$251.00
4	Leather Seats	$323.00
5	Sirius XM Radio	$272.00
\.


--
-- Name: customization_options_custom_id_seq; Type: SEQUENCE SET; Schema: public; Owner: p32001c
--

SELECT pg_catalog.setval('customization_options_custom_id_seq', 1, false);


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY employee (emp_id, emp_name, commission) FROM stdin;
1	Jim Friendly	30.00
2	Diane Graham	10.00
3	Keven Greene	10.00
4	Joshua Fraser	5.00
5	Brian Morrison	0.00
\.


--
-- Name: employee_emp_id_seq; Type: SEQUENCE SET; Schema: public; Owner: p32001c
--

SELECT pg_catalog.setval('employee_emp_id_seq', 5, true);


--
-- Data for Name: features; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY features (feat_id, feat_name) FROM stdin;
0	AC
1	Heated Seats
2	Power Windows
3	Sunroof
4	Leather Seats
5	Sirius XM Radio
\.


--
-- Name: features_feat_id_seq; Type: SEQUENCE SET; Schema: public; Owner: p32001c
--

SELECT pg_catalog.setval('features_feat_id_seq', 1, false);


--
-- Data for Name: financing; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY financing (fin_id, amount, type, name, addr) FROM stdin;
1	$15,000.00	bank	bank of america	123 Fake St.
2	$4,000.00	dealership	ford	543 False Ave.
\.


--
-- Name: financing_fin_id_seq; Type: SEQUENCE SET; Schema: public; Owner: p32001c
--

SELECT pg_catalog.setval('financing_fin_id_seq', 2, true);


--
-- Data for Name: has_customization; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY has_customization (custom_id, sale_id) FROM stdin;
\.


--
-- Data for Name: has_features; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY has_features (feat_id, vin) FROM stdin;
\.


--
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY payment (payment_id, amount, trade_id, fin_id) FROM stdin;
1	$10,000.00	\N	\N
2	$10,000.00	\N	1
\.


--
-- Name: payment_payment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: p32001c
--

SELECT pg_catalog.setval('payment_payment_id_seq', 3, true);


--
-- Data for Name: practice; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY practice (practice_id, practice_int) FROM stdin;
1	0
2	1
3	2
4	3
5	4
6	5
7	6
8	7
9	8
10	9
11	10
12	11
13	12
14	13
15	14
16	15
17	16
18	17
19	18
20	19
21	20
22	21
23	22
24	23
25	24
26	25
27	26
28	27
29	28
30	29
31	30
32	31
33	32
34	33
35	34
36	35
37	36
38	37
39	38
40	39
41	40
42	41
43	42
44	43
45	44
46	45
47	46
48	47
49	48
50	49
51	50
52	51
53	52
54	53
55	54
56	55
57	56
58	57
59	58
60	59
61	60
62	61
63	62
64	63
65	64
66	65
67	66
68	67
69	68
70	69
71	70
72	71
73	72
74	73
75	74
76	75
77	76
78	77
79	78
80	79
81	80
82	81
83	82
84	83
85	84
86	85
87	86
88	87
89	88
90	89
91	90
92	91
93	92
94	93
95	94
96	95
97	96
98	97
99	98
100	99
\.


--
-- Name: practice_practice_id_seq; Type: SEQUENCE SET; Schema: public; Owner: p32001c
--

SELECT pg_catalog.setval('practice_practice_id_seq', 100, true);


--
-- Data for Name: sale; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY sale (sale_id, is_approved, price, date, emp_requested, tax_rate, license_fee, cus_id, vin, emp_id, payment_id, warranty_id) FROM stdin;
1	f	$10,000.00	2017-01-01	f	0.05	$225.00	2	555555	3	1	1
2	f	$15,000.00	2017-01-01	f	0.05	$75.00	3	666666	4	2	1
\.


--
-- Name: sale_sale_id_seq; Type: SEQUENCE SET; Schema: public; Owner: p32001c
--

SELECT pg_catalog.setval('sale_sale_id_seq', 3, true);


--
-- Data for Name: trade_in; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY trade_in (trade_id, vin, miles, condition, value) FROM stdin;
\.


--
-- Name: trade_in_trade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: p32001c
--

SELECT pg_catalog.setval('trade_in_trade_id_seq', 1, true);


--
-- Data for Name: warranty; Type: TABLE DATA; Schema: public; Owner: p32001c
--

COPY warranty (warranty_id, type, cost, duration, miles) FROM stdin;
1	Standard	$0.00	60	5000
2	Extended	$100.00	120	10000
3	Limited	$0.00	30	2000
\.


--
-- Name: warranty_warranty_id_seq; Type: SEQUENCE SET; Schema: public; Owner: p32001c
--

SELECT pg_catalog.setval('warranty_warranty_id_seq', 3, true);


--
-- Name: car_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY car
    ADD CONSTRAINT car_pkey PRIMARY KEY (vin);


--
-- Name: customer_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (cus_id);


--
-- Name: customization_options_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY customization_options
    ADD CONSTRAINT customization_options_pkey PRIMARY KEY (custom_id);


--
-- Name: employee_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (emp_id);


--
-- Name: features_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY features
    ADD CONSTRAINT features_pkey PRIMARY KEY (feat_id);


--
-- Name: financing_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY financing
    ADD CONSTRAINT financing_pkey PRIMARY KEY (fin_id);


--
-- Name: has_customization_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY has_customization
    ADD CONSTRAINT has_customization_pkey PRIMARY KEY (custom_id, sale_id);


--
-- Name: has_features_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY has_features
    ADD CONSTRAINT has_features_pkey PRIMARY KEY (feat_id, vin);


--
-- Name: payment_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (payment_id);


--
-- Name: practice_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY practice
    ADD CONSTRAINT practice_pkey PRIMARY KEY (practice_id);


--
-- Name: sale_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT sale_pkey PRIMARY KEY (sale_id);


--
-- Name: trade_in_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY trade_in
    ADD CONSTRAINT trade_in_pkey PRIMARY KEY (trade_id);


--
-- Name: warranty_pkey; Type: CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY warranty
    ADD CONSTRAINT warranty_pkey PRIMARY KEY (warranty_id);


--
-- Name: has_customization_custom_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY has_customization
    ADD CONSTRAINT has_customization_custom_id_fkey FOREIGN KEY (custom_id) REFERENCES customization_options(custom_id) ON DELETE CASCADE;


--
-- Name: has_customization_sale_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY has_customization
    ADD CONSTRAINT has_customization_sale_id_fkey FOREIGN KEY (sale_id) REFERENCES sale(sale_id) ON DELETE CASCADE;


--
-- Name: has_features_feat_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY has_features
    ADD CONSTRAINT has_features_feat_id_fkey FOREIGN KEY (feat_id) REFERENCES features(feat_id) ON DELETE CASCADE;


--
-- Name: has_features_vin_fkey; Type: FK CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY has_features
    ADD CONSTRAINT has_features_vin_fkey FOREIGN KEY (vin) REFERENCES car(vin) ON DELETE CASCADE;


--
-- Name: payment_fin_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY payment
    ADD CONSTRAINT payment_fin_id_fkey FOREIGN KEY (fin_id) REFERENCES financing(fin_id) ON DELETE CASCADE;


--
-- Name: payment_trade_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY payment
    ADD CONSTRAINT payment_trade_id_fkey FOREIGN KEY (trade_id) REFERENCES trade_in(trade_id) ON DELETE CASCADE;


--
-- Name: sale_cus_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT sale_cus_id_fkey FOREIGN KEY (cus_id) REFERENCES customer(cus_id) ON DELETE CASCADE;


--
-- Name: sale_emp_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT sale_emp_id_fkey FOREIGN KEY (emp_id) REFERENCES employee(emp_id) ON DELETE CASCADE;


--
-- Name: sale_payment_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT sale_payment_id_fkey FOREIGN KEY (payment_id) REFERENCES payment(payment_id) ON DELETE CASCADE;


--
-- Name: sale_vin_fkey; Type: FK CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT sale_vin_fkey FOREIGN KEY (vin) REFERENCES car(vin) ON DELETE CASCADE;


--
-- Name: sale_warranty_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT sale_warranty_id_fkey FOREIGN KEY (warranty_id) REFERENCES warranty(warranty_id) ON DELETE CASCADE;


--
-- Name: trade_in_vin_fkey; Type: FK CONSTRAINT; Schema: public; Owner: p32001c
--

ALTER TABLE ONLY trade_in
    ADD CONSTRAINT trade_in_vin_fkey FOREIGN KEY (vin) REFERENCES car(vin);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

