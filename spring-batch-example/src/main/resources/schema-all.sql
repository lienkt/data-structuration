DROP TABLE people IF EXISTS;

CREATE TABLE people  (
                         person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
                         first_name VARCHAR(20),
                         last_name VARCHAR(20)
);

DROP TABLE item_state IF EXISTS;

CREATE TABLE item_state  (
	contact_email VARCHAR(100),
    state VARCHAR(20)
);

DROP TABLE contacts IF EXISTS;

CREATE TABLE contacts  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
	contact_email VARCHAR(100),
	contact_first_name VARCHAR(50),
	contact_last_name VARCHAR(50),
	contact_address VARCHAR(200),
	contact_city VARCHAR(100),
	contact_country VARCHAR(50),
	contact_birthdate Date
);

INSERT INTO contacts (contact_email, contact_first_name, contact_last_name, contact_address, contact_city, contact_country, contact_birthdate)
VALUES  ('jbutt@gmail.com', 'James', 'Butt', '6649 N Blue Gum St', 'New Orleans', 'USA', '1972-09-15'),
        ('josephine_darakjy@darakjy.org', 'Josephine', 'Darakjy', '4 B Blue Ridge Blvd', 'Brighton', 'USA', '1978-03-12'),
        ('art@venere.org', 'Art', 'Venere', '8 W Cerritos Ave #54', 'Bridgeport', 'USA', '1977-12-26'),
        ('lpaprocki@hotmail.com', 'Lenna', 'Paprocki', '639 Main St', 'Anchorage', 'USA', '1981-02-19'),
        ('donette.foller@cox.net', 'Donette', 'Foller', '34 Center St', 'Hamilton', 'USA', '1984-04-21'),
        ('simona@morasca.com', 'Simona', 'Morasca', '3 Mcauley Dr', 'Ashland', 'USA', '1996-09-03'),
        ('mitsue_tollner@yahoo.com', 'Mitsue', 'Tollner', '7 Eads St', 'Chicago', 'USA', '1983-05-03'),
        ('leota@hotmail.com', 'Leota', 'Dilliard', '7 W Jackson Blvd', 'San Jose', 'USA', '1993-03-13'),
        ('sage_wieser@cox.net', 'Sage', 'Wieser', '5 Boston Ave #88', 'Sioux Falls', 'USA', '1990-04-25'),
        ('kris@gmail.com', 'Kris', 'Marrier', '228 Runamuck Pl #2808', 'Baltimore', 'USA', '1993-02-08'),
        ('minna_amigon@yahoo.com', 'Minna', 'Amigon', '2371 Jerrold Ave', 'Kulpsville', 'USA', '1990-12-12'),
        ('amaclead@gmail.com', 'Abel', 'Maclead', '37275 St  Rt 17m M', 'Middle Island', 'USA', '1980-01-01'),
        ('kiley.caldarera@aol.com', 'Kiley', 'Caldarera', '25 E 75th St #69', 'Los Angeles', 'USA', '1987-09-24'),
        ('gruta@cox.net', 'Graciela', 'Ruta', '98 Connecticut Ave Nw', 'Chagrin Falls', 'USA', '1978-10-02'),
        ('calbares@gmail.com', 'Cammy', 'Albares', '56 E Morehead St', 'Laredo', 'USA', '1993-07-26'),
        ('mattie@aol.com', 'Mattie', 'Poquette', '73 State Road 434 E', 'Phoenix', 'USA', '1972-06-30'),
        ('meaghan@hotmail.com', 'Meaghan', 'Garufi', '69734 E Carrillo St', 'Mc Minnville', 'USA', '1982-12-17'),
        ('gladys.rim@rim.org', 'Gladys', 'Rim', '322 New Horizon Blvd', 'Milwaukee', 'USA', '1991-09-16'),
        ('yuki_whobrey@aol.com', 'Yuki', 'Whobrey', '1 State Route 27', 'Taylor', 'USA', '1990-06-30'),
        ('fletcher.flosi@yahoo.com', 'Fletcher', 'Flosi', '394 Manchester Blvd', 'Rockford', 'USA', '1972-04-27'),
        ('bette_nicka@cox.net', 'Bette', 'Nicka', '6 S 33rd St', 'Aston', 'USA', '1992-05-24'),
        ('vinouye@aol.com', 'Veronika', 'Inouye', '6 Greenleaf Ave', 'San Jose', 'USA', '1993-01-19'),
        ('willard@hotmail.com', 'Willard', 'Kolmetz', '618 W Yakima Ave', 'Irving', 'USA', '1977-02-06'),
        ('mroyster@royster.com', 'Maryann', 'Royster', '74 S Westgate St', 'Albany', 'USA', '1989-10-03'),
        ('alisha@slusarski.com', 'Alisha', 'Slusarski', '3273 State St', 'Middlesex', 'USA', '1983-09-05'),
        ('allene_iturbide@cox.net', 'Allene', 'Iturbide', '1 Central Ave', 'Stevens Point', 'USA', '1975-01-08'),
        ('chanel.caudy@caudy.org', 'Chanel', 'Caudy', '86 Nw 66th St #8673', 'Shawnee', 'USA', '1982-08-16'),
        ('ezekiel@chui.com', 'Ezekiel', 'Chui', '2 Cedar Ave #84', 'Easton', 'USA', '1982-05-23'),
        ('wkusko@yahoo.com', 'Willow', 'Kusko', '90991 Thorburn Ave', 'New York', 'USA', '1974-05-04'),
        ('bfigeroa@aol.com', 'Bernardo', 'Figeroa', '386 9th Ave N', 'Conroe', 'USA', '1993-08-05'),
        ('ammie@corrio.com', 'Ammie', 'Corrio', '74874 Atlantic Ave', 'Columbus', 'USA', '1988-04-11'),
        ('francine_vocelka@vocelka.com', 'Francine', 'Vocelka', '366 South Dr', 'Las Cruces', 'USA', '1995-11-15'),
        ('ernie_stenseth@aol.com', 'Ernie', 'Stenseth', '45 E Liberty St', 'Ridgefield Park', 'USA', '1986-09-16'),
        ('albina@glick.com', 'Albina', 'Glick', '4 Ralph Ct', 'Dunellen', 'USA', '1991-05-15'),
        ('asergi@gmail.com', 'Alishia', 'Sergi', '2742 Distribution Way', 'New York', 'USA', '1982-09-08'),
        ('solange@shinko.com', 'Solange', 'Shinko', '426 Wolf St', 'Metairie', 'USA', '1991-05-17'),
        ('jose@yahoo.com', 'Jose', 'Stockham', '128 Bransten Rd', 'New York', 'USA', '1979-02-08'),
        ('rozella.ostrosky@ostrosky.com', 'Rozella', 'Ostrosky', '17 Morena Blvd', 'Camarillo', 'USA', '1990-02-22'),
        ('valentine_gillian@gmail.com', 'Valentine', 'Gillian', '775 W 17th St', 'San Antonio', 'USA', '1981-01-12'),
        ('kati.rulapaugh@hotmail.com', 'Kati', 'Rulapaugh', '6980 Dorsett Rd', 'Abilene', 'USA', '1989-04-26'),
        ('youlanda@aol.com', 'Youlanda', 'Schemmer', '2881 Lewis Rd', 'Prineville', 'USA', '1976-10-22'),
        ('doldroyd@aol.com', 'Dyan', 'Oldroyd', '7219 Woodfield Rd', 'Overland Park', 'USA', '1976-05-14'),
        ('roxane@hotmail.com', 'Roxane', 'Campain', '1048 Main St', 'Fairbanks', 'USA', '1974-12-06'),
        ('lperin@perin.org', 'Lavera', 'Perin', '678 3rd Ave', 'Miami', 'USA', '1986-05-21'),
        ('erick.ferencz@aol.com', 'Erick', 'Ferencz', '20 S Babcock St', 'Fairbanks', 'USA', '1984-11-11'),
        ('fsaylors@saylors.org', 'Fatima', 'Saylors', '2 Lighthouse Ave', 'Hopkins', 'USA', '1973-02-12'),
        ('jina_briddick@briddick.com', 'Jina', 'Briddick', '38938 Park Blvd', 'Boston', 'USA', '1987-01-13'),
        ('kanisha_waycott@yahoo.com', 'Kanisha', 'Waycott', '5 Tomahawk Dr', 'Los Angeles', 'USA', '1992-10-12'),
        ('emerson.bowley@bowley.org', 'Emerson', 'Bowley', '762 S Main St', 'Madison', 'USA', '1986-10-24'),
        ('bmalet@yahoo.com', 'Blair', 'Malet', '209 Decker Dr', 'Philadelphia', 'USA', '1983-11-24'),
        ('bbolognia@yahoo.com', 'Brock', 'Bolognia', '4486 W O St #1', 'New York', 'USA', '1979-12-31'),
        ('lnestle@hotmail.com', 'Lorrie', 'Nestle', '39 S 7th St', 'Tullahoma', 'USA', '1970-08-04'),
        ('sabra@uyetake.org', 'Sabra', 'Uyetake', '98839 Hawthorne Blvd #6101', 'Columbia', 'USA', '1976-05-22'),
        ('mmastella@mastella.com', 'Marjory', 'Mastella', '71 San Mateo Ave', 'Wayne', 'USA', '1993-07-30'),
        ('karl_klonowski@yahoo.com', 'Karl', 'Klonowski', '76 Brooks St #9', 'Flemington', 'USA', '1973-10-05'),
        ('twenner@aol.com', 'Tonette', 'Wenner', '4545 Courthouse Rd', 'Westbury', 'USA', '1984-09-24'),
        ('amber_monarrez@monarrez.org', 'Amber', 'Monarrez', '14288 Foster Ave #4121', 'Jenkintown', 'USA', '1970-09-14'),
        ('shenika@gmail.com', 'Shenika', 'Seewald', '4 Otis St', 'Van Nuys', 'USA', '1974-04-01'),
        ('delmy.ahle@hotmail.com', 'Delmy', 'Ahle', '65895 S 16th St', 'Providence', 'USA', '1997-07-01'),
        ('deeanna_juhas@gmail.com', 'Deeanna', 'Juhas', '14302 Pennsylvania Ave', 'Huntingdon Valley', 'USA', '1973-08-07'),
        ('bpugh@aol.com', 'Blondell', 'Pugh', '201 Hawk Ct', 'Providence', 'USA', '1987-03-17'),
        ('jamal@vanausdal.org', 'Jamal', 'Vanausdal', '53075 Sw 152nd Ter #615', 'Monroe Township', 'USA', '1998-11-04'),
        ('cecily@hollack.org', 'Cecily', 'Hollack', '59 N Groesbeck Hwy', 'Austin', 'USA', '1997-04-19'),
        ('carmelina_lindall@lindall.com', 'Carmelina', 'Lindall', '2664 Lewis Rd', 'Littleton', 'USA', '1985-12-16'),
        ('maurine_yglesias@yglesias.com', 'Maurine', 'Yglesias', '59 Shady Ln #53', 'Milwaukee', 'USA', '1983-08-02'),
        ('tawna@gmail.com', 'Tawna', 'Buvens', '3305 Nabell Ave #679', 'New York', 'USA', '1996-10-28'),
        ('penney_weight@aol.com', 'Penney', 'Weight', '18 Fountain St', 'Anchorage', 'USA', '1971-05-07'),
        ('elly_morocco@gmail.com', 'Elly', 'Morocco', '7 W 32nd St', 'Erie', 'USA', '1979-11-28'),
        ('ilene.eroman@hotmail.com', 'Ilene', 'Eroman', '2853 S Central Expy', 'Glen Burnie', 'USA', '1983-04-09'),
        ('vmondella@mondella.com', 'Vallie', 'Mondella', '74 W College St', 'Boise', 'USA', '1973-10-25'),
        ('kallie.blackwood@gmail.com', 'Kallie', 'Blackwood', '701 S Harrison Rd', 'San Francisco', 'USA', '1984-03-16'),
        ('johnetta_abdallah@aol.com', 'Johnetta', 'Abdallah', '1088 Pinehurst St', 'Chapel Hill', 'USA', '1977-08-26'),
        ('brhym@rhym.com', 'Bobbye', 'Rhym', '30 W 80th St #1995', 'San Carlos', 'USA', '1971-03-12'),
        ('micaela_rhymes@gmail.com', 'Micaela', 'Rhymes', '20932 Hedley St', 'Concord', 'USA', '1980-02-14'),
        ('tamar@hotmail.com', 'Tamar', 'Hoogland', '2737 Pistorio Rd #9230', 'London', 'USA', '1996-04-30'),
        ('moon@yahoo.com', 'Moon', 'Parlato', '74989 Brandon St', 'Wellsville', 'USA', '1987-03-22'),
        ('laurel_reitler@reitler.com', 'Laurel', 'Reitler', '6 Kains Ave', 'Baltimore', 'USA', '1996-09-13'),
        ('delisa.crupi@crupi.com', 'Delisa', 'Crupi', '47565 W Grand Ave', 'Newark', 'USA', '1982-10-16'),
        ('viva.toelkes@gmail.com', 'Viva', 'Toelkes', '4284 Dorigo Ln', 'Chicago', 'USA', '1990-07-07'),
        ('elza@yahoo.com', 'Elza', 'Lipke', '6794 Lake Dr E', 'Newark', 'USA', '1989-05-26'),
        ('devorah@hotmail.com', 'Devorah', 'Chickering', '31 Douglas Blvd #950', 'Clovis', 'USA', '1979-12-17'),
        ('timothy_mulqueen@mulqueen.org', 'Timothy', 'Mulqueen', '44 W 4th St', 'Staten Island', 'USA', '1987-05-16'),
        ('ahoneywell@honeywell.com', 'Arlette', 'Honeywell', '11279 Loytan St', 'Jacksonville', 'USA', '1977-05-06'),
        ('dominque.dickerson@dickerson.org', 'Dominque', 'Dickerson', '69 Marquette Ave', 'Hayward', 'USA', '1993-09-07'),
        ('lettie_isenhower@yahoo.com', 'Lettie', 'Isenhower', '70 W Main St', 'Beachwood', 'USA', '1995-11-05'),
        ('mmunns@cox.net', 'Myra', 'Munns', '461 Prospect Pl #316', 'Euless', 'USA', '1986-12-06'),
        ('stephaine@barfield.com', 'Stephaine', 'Barfield', '47154 Whipple Ave Nw', 'Gardena', 'USA', '1974-11-20'),
        ('lai.gato@gato.org', 'Lai', 'Gato', '37 Alabama Ave', 'Evanston', 'USA', '1986-09-01'),
        ('stephen_emigh@hotmail.com', 'Stephen', 'Emigh', '3777 E Richmond St #900', 'Akron', 'USA', '1980-09-05'),
        ('tshields@gmail.com', 'Tyra', 'Shields', '3 Fort Worth Ave', 'Philadelphia', 'USA', '1984-04-08'),
        ('twardrip@cox.net', 'Tammara', 'Wardrip', '4800 Black Horse Pike', 'Burlingame', 'USA', '1978-03-11'),
        ('cory.gibes@gmail.com', 'Cory', 'Gibes', '83649 W Belmont Ave', 'San Gabriel', 'USA', '1978-03-08'),
        ('danica_bruschke@gmail.com', 'Danica', 'Bruschke', '840 15th Ave', 'Waco', 'USA', '1984-03-17'),
        ('wilda@cox.net', 'Wilda', 'Giguere', '1747 Calle Amanecer #2', 'Anchorage', 'USA', '1984-10-28'),
        ('elvera.benimadho@cox.net', 'Elvera', 'Benimadho', '99385 Charity St #840', 'San Jose', 'USA', '1972-08-03'),
        ('carma@cox.net', 'Carma', 'Vanheusen', '68556 Central Hwy', 'San Leandro', 'USA', '1981-09-15'),
        ('malinda.hochard@yahoo.com', 'Malinda', 'Hochard', '55 Riverside Ave', 'Indianapolis', 'USA', '1988-07-10'),
        ('natalie.fern@hotmail.com', 'Natalie', 'Fern', '7140 University Ave', 'Rock Springs', 'USA', '1987-11-09'),
        ('lisha@centini.org', 'Lisha', 'Centini', '64 5th Ave #1153', 'Mc Lean', 'USA', '1980-03-02');