# ReportAssignment

ReportAssignment is a maven Project aimed at creating a validation service that reads the file and gives a report with the invalid records.


### Folder structure

#### SRC
contains java main and test classes. I have tried to create an extensible code So that it can be easier to maintain, extend and test. 
Some code is left for implemnetion. 
Written unit test cases only for business logic due to time constraints

##### ReportGeneratorService 
It is the main starter class which contains main method which takes input data file and generates an output file consisting failed records. 
Output file has three columns consisitng of the failed transaction's reference, description and reasin for its failure.

##### Validations
1) All transaction references should be unique
2) For each record the end balance needs to be correct given the start balance and mutation. I have considered the second record which has the duplicate reference   as faulty record.

* If both validations fails, for now, the reason will just show the last failed validation which is "The Final Balance is wrong".

#### INPUT
Input folder needs to have the input data files.

#### OUTPUT
Output folder gets the final output file. Currently, we can get only excel file as output report. 

#### LOGS
Logs folder contains the generated logs. Have used Log4j2 for logging. Due to time constraints, I have not put logger in each and every class.




