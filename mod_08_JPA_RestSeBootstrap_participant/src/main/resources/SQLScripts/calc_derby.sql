CREATE TABLE calculations(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
        (START WITH 1, INCREMENT BY 1),
    principal DOUBLE,
    annualInterestRate DOUBLE,
    compoundPerTimeUnit DOUBLE,
    time DOUBLE,
    result VARCHAR(25));
	
INSERT INTO calculations(principal, annualInterestRate,	compoundPerTimeUnit, time, result)
	values(34, 0.13, 12, 6, '73.85');
