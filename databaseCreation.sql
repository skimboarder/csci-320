DROP TABLE IF EXISTS customization_options CASCADE; 
CREATE TABLE customization_options ( custom_id serial NOT NULL PRIMARY KEY, custom_name character varying(70) NOT NULL, cost integer NOT NULL );
DROP TABLE IF EXISTS features CASCADE; 
CREATE TABLE features ( feat_id serial NOT NULL PRIMARY KEY, feat_name character varying(70) NOT NULL );
DROP TABLE IF EXISTS customer CASCADE; 
CREATE TABLE customer ( cus_id serial NOT NULL PRIMARY KEY, name character varying(70) NOT NULL, ref_type character varying(70) NOT NULL, ref_origin character varying(70) NOT NULL );
DROP TABLE IF EXISTS employee CASCADE; 
CREATE TABLE employee ( emp_id serial NOT NULL PRIMARY KEY, emp_name character varying(70) NOT NULL, commission numeric(5,2) NOT NULL, CONSTRAINT value_is_percentage CHECK (((commission > (1)::numeric) AND (commission < (100)::numeric) )) );
DROP TABLE IF EXISTS trade_in CASCADE; 
CREATE TABLE trade_in ( trade_id serial NOT NULL PRIMARY KEY, vin integer NOT NULL, miles integer NOT NULL, condition character varying(250) NOT NULL, value money NOT NULL, date date NOT NULL );
DROP TABLE IF EXISTS financing CASCADE; 
CREATE TABLE financing ( fin_id serial NOT NULL PRIMARY KEY, amount money NOT NULL, type character varying(250) NOT NULL, name character varying(70) NOT NULL, addr character varying(100) NOT NULL );
DROP TABLE IF EXISTS payment CASCADE; 
CREATE TABLE payment ( payment_id serial NOT NULL PRIMARY KEY, amount money NOT NULL, trade_id integer NOT NULL REFERENCES trade_in(trade_id) ON DELETE CASCADE, fin_id integer NOT NULL REFERENCES financing(fin_id) ON DELETE CASCADE );
DROP TABLE IF EXISTS car CASCADE; 
CREATE TABLE car ( vin integer NOT NULL PRIMARY KEY, sticker_price money NOT NULL, make character varying(70) NOT NULL, model character varying(70) NOT NULL, year integer NOT NULL, color character varying(70) NOT NULL, is_new boolean NOT NULL, is_sold boolean NOT NULL, min_price money NOT NULL, mileage integer NOT NULL );
DROP TABLE IF EXISTS warranty CASCADE; 
CREATE TABLE warranty ( warranty_id serial NOT NULL PRIMARY KEY, type character varying(70) NOT NULL, cost money NOT NULL, duration integer NOT NULL, miles integer NOT NULL );
DROP TABLE IF EXISTS sale CASCADE; 
CREATE TABLE sale ( sale_id integer NOT NULL PRIMARY KEY, is_approved boolean NOT NULL, price money NOT NULL, date date NOT NULL, emp_requested boolean NOT NULL, tax_rate numeric(5,2) NOT NULL, license_fee money NOT NULL, cus_id integer NOT NULL REFERENCES customer(cus_id) ON DELETE CASCADE, vin integer NOT NULL REFERENCES car(vin) ON DELETE CASCADE, emp_id integer NOT NULL REFERENCES employee(emp_id) ON DELETE CASCADE, payment_id integer NOT NULL REFERENCES payment(payment_id) ON DELETE CASCADE, warranty_id integer NOT NULL REFERENCES warranty(warranty_id) ON DELETE CASCADE, CONSTRAINT value_is_percentage CHECK (((tax_rate > (1)::numeric) AND (tax_rate < (100)::numeric) )) );
DROP TABLE IF EXISTS has_features CASCADE; 
CREATE TABLE has_features ( feat_id integer NOT NULL REFERENCES features(feat_id) ON DELETE CASCADE, vin integer NOT NULL REFERENCES car(vin) ON DELETE CASCADE, PRIMARY KEY(feat_id, vin) );
DROP TABLE IF EXISTS has_customization CASCADE; 
CREATE TABLE has_customization ( custom_id integer NOT NULL REFERENCES customization_options(custom_id) ON DELETE CASCADE, sale_id integer NOT NULL REFERENCES sale(sale_id) ON DELETE CASCADE, PRIMARY KEY(custom_id, sale_id) );
INSERT INTO features (feat_id, feat_name) VALUES (0, 'AC');
INSERT INTO features (feat_id, feat_name) VALUES (1, 'Heated Seats');
INSERT INTO features (feat_id, feat_name) VALUES (2, 'Power Windows');
INSERT INTO features (feat_id, feat_name) VALUES (3, 'Sunroof');
INSERT INTO features (feat_id, feat_name) VALUES (4, 'Leather Seats');
INSERT INTO features (feat_id, feat_name) VALUES (5, 'Sirius XM Radio');
INSERT INTO customization_options (custom_id, custom_name, cost) VALUES (0, 'AC', 63);
INSERT INTO customization_options (custom_id, custom_name, cost) VALUES (1, 'Heated Seats', 437);
INSERT INTO customization_options (custom_id, custom_name, cost) VALUES (2, 'Power Windows', 156);
INSERT INTO customization_options (custom_id, custom_name, cost) VALUES (3, 'Sunroof', 148);
INSERT INTO customization_options (custom_id, custom_name, cost) VALUES (4, 'Leather Seats', 407);
INSERT INTO customization_options (custom_id, custom_name, cost) VALUES (5, 'Sirius XM Radio', 356);
INSERT INTO warranty (type, cost, duration, miles) VALUES ('Standard', 0, 60, 5000);
INSERT INTO warranty (type, cost, duration, miles) VALUES ('Extended', 100, 120, 10000);
INSERT INTO warranty (type, cost, duration, miles) VALUES ('Limited', 0, 30, 2000);
INSERT INTO customer (name, ref_type, ref_origin) VALUES ('Frank Murray', 'none', 'none');
INSERT INTO customer (name, ref_type, ref_origin) VALUES ('Jan Scott', 'web', 'facebook.com');
INSERT INTO customer (name, ref_type, ref_origin) VALUES ('Adrian Blake', 'mouth', 'Emma Peake');
INSERT INTO customer (name, ref_type, ref_origin) VALUES ('Emma Peake', 'web', 'cars.com');
INSERT INTO customer (name, ref_type, ref_origin) VALUES ('Adam Parr', 'tv ad', 'channel 3');
INSERT INTO employee (emp_name, commission) VALUES ('Jim Friendly', 30);
INSERT INTO employee (emp_name, commission) VALUES ('Diane Graham', 10);
INSERT INTO employee (emp_name, commission) VALUES ('Keven Greene', 10);
INSERT INTO employee (emp_name, commission) VALUES ('Joshua Fraser', 5);
INSERT INTO employee (emp_name, commission) VALUES ('Brian Morrison', 5);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (805514, 5630, 'Ford', 'mustang', 1997, 'red', true, false, 0.3, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (538257, 12623, 'Ford', 'focus', 1997, 'black', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (555251, 16965, 'Ford', 'fusion', 1997, 'black', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (514294, 12466, 'Ford', 'taurus', 1997, 'red', true, false, 0.1, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (142372, 18932, 'Ford', 'mustang', 1998, 'black', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (301831, 11579, 'Ford', 'focus', 1998, 'silver', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (907917, 17774, 'Ford', 'fusion', 1998, 'black', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (531787, 11326, 'Ford', 'taurus', 1998, 'red', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (911902, 12396, 'Ford', 'mustang', 1999, 'silver', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (947052, 6998, 'Ford', 'focus', 1999, 'red', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (870729, 14620, 'Ford', 'fusion', 1999, 'red', true, false, 0.1, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (309430, 6057, 'Ford', 'taurus', 1999, 'silver', true, false, 0.3, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (138595, 12389, 'Ford', 'mustang', 2000, 'silver', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (874421, 6015, 'Ford', 'focus', 2000, 'silver', true, false, 0.3, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (367011, 14688, 'Ford', 'fusion', 2000, 'silver', true, false, 0.1, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (497914, 9755, 'Ford', 'taurus', 2000, 'silver', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (552001, 10312, 'Ford', 'mustang', 2001, 'red', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (180215, 7696, 'Ford', 'focus', 2001, 'red', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (122776, 19202, 'Ford', 'fusion', 2001, 'red', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (703550, 13004, 'Ford', 'taurus', 2001, 'black', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (351235, 5926, 'Ford', 'mustang', 2002, 'red', true, false, 0.1, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (245253, 7000, 'Ford', 'focus', 2002, 'red', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (505699, 13091, 'Ford', 'fusion', 2002, 'silver', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (523236, 14677, 'Ford', 'taurus', 2002, 'red', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (588183, 16894, 'Ford', 'mustang', 2003, 'red', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (504660, 5831, 'Ford', 'focus', 2003, 'silver', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (583681, 9555, 'Ford', 'fusion', 2003, 'red', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (764689, 13590, 'Ford', 'taurus', 2003, 'silver', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (805256, 11882, 'Ford', 'mustang', 2004, 'silver', true, false, 0.1, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (114169, 18680, 'Ford', 'focus', 2004, 'red', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (881872, 19907, 'Ford', 'fusion', 2004, 'black', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (577771, 17224, 'Ford', 'taurus', 2004, 'black', true, false, 0.3, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (162179, 7490, 'Ford', 'mustang', 2005, 'silver', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (454152, 18290, 'Ford', 'focus', 2005, 'black', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (331339, 9555, 'Ford', 'fusion', 2005, 'red', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (133301, 19883, 'Ford', 'taurus', 2005, 'black', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (765972, 17246, 'Ford', 'mustang', 2006, 'red', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (446999, 9733, 'Ford', 'focus', 2006, 'silver', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (535758, 7859, 'Ford', 'fusion', 2006, 'black', true, false, 0.1, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (515156, 14808, 'Ford', 'taurus', 2006, 'black', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (593001, 5431, 'Ford', 'mustang', 2007, 'black', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (785304, 10298, 'Ford', 'focus', 2007, 'silver', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (189239, 11853, 'Ford', 'fusion', 2007, 'silver', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (205741, 9184, 'Ford', 'taurus', 2007, 'black', true, false, 0.3, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (679214, 19574, 'Ford', 'mustang', 2008, 'red', true, false, 0.3, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (737377, 6202, 'Ford', 'focus', 2008, 'silver', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (997122, 8249, 'Ford', 'fusion', 2008, 'red', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (635972, 7562, 'Ford', 'taurus', 2008, 'silver', true, false, 0.3, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (509262, 14178, 'Ford', 'mustang', 2009, 'red', true, false, 0.1, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (424070, 9805, 'Ford', 'focus', 2009, 'red', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (440108, 18790, 'Ford', 'fusion', 2009, 'silver', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (692765, 5544, 'Ford', 'taurus', 2009, 'black', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (651384, 13517, 'Ford', 'mustang', 2010, 'silver', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (187836, 15315, 'Ford', 'focus', 2010, 'black', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (540784, 13031, 'Ford', 'fusion', 2010, 'silver', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (693213, 16209, 'Ford', 'taurus', 2010, 'red', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (130678, 19631, 'Ford', 'mustang', 2011, 'silver', true, false, 0.1, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (822552, 14966, 'Ford', 'focus', 2011, 'silver', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (520396, 11098, 'Ford', 'fusion', 2011, 'silver', true, false, 0.3, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (176617, 10927, 'Ford', 'taurus', 2011, 'silver', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (680438, 17616, 'Ford', 'mustang', 2012, 'black', true, false, 0.4, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (679661, 7765, 'Ford', 'focus', 2012, 'red', true, false, 0.3, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (622843, 8434, 'Ford', 'fusion', 2012, 'silver', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (269156, 11969, 'Ford', 'taurus', 2012, 'black', true, false, 0.3, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (551268, 10914, 'Ford', 'mustang', 2013, 'black', true, false, 0.3, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (724528, 14377, 'Ford', 'focus', 2013, 'silver', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (188411, 9589, 'Ford', 'fusion', 2013, 'black', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (708533, 8905, 'Ford', 'taurus', 2013, 'red', true, false, 0.1, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (879597, 6700, 'Ford', 'mustang', 2014, 'red', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (351319, 17035, 'Ford', 'focus', 2014, 'silver', true, false, 0.1, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (614280, 15173, 'Ford', 'fusion', 2014, 'black', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (796254, 19503, 'Ford', 'taurus', 2014, 'black', true, false, 0.1, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (869853, 14846, 'Ford', 'mustang', 2015, 'red', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (157652, 12714, 'Ford', 'focus', 2015, 'silver', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (973310, 12059, 'Ford', 'fusion', 2015, 'black', true, false, 0.3, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (288485, 17587, 'Ford', 'taurus', 2015, 'red', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (815488, 10898, 'Ford', 'mustang', 2016, 'black', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (725405, 13417, 'Ford', 'focus', 2016, 'red', true, false, 0.0, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (402682, 11558, 'Ford', 'fusion', 2016, 'silver', true, false, 0.2, 0);
INSERT INTO car (vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) VALUES (682125, 14870, 'Ford', 'taurus', 2016, 'black', true, false, 0.4, 0);
