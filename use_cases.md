USE CASE 1: Produce a Report of All Countries by Population
CHARACTERISTIC INFORMATION

Goal in Context
As a data analyst, I want to produce a report on the population of all countries in the world so that I can identify and compare the most and least populated nations.

Scope
Global Population Reporting System.

Level
Primary task.

Preconditions
Database connection is available and contains up-to-date population data for all countries.

Success End Condition
A report showing all countries sorted by population is displayed.

Failed End Condition
No report is produced, or an error message is shown.

Primary Actor
Data Analyst.

Trigger
The analyst requests a global country population report.

MAIN SUCCESS SCENARIO

The analyst opens the population reporting system.

The analyst selects the option “World Country Report”.

The system retrieves all countries from the database.

The system sorts the countries by population in descending order.

The system displays the complete report.

EXTENSIONS

 No data found → System displays “No countries available to display.”

SUB-VARIATIONS

None.

SCHEDULE

DUE DATE: Release 1.0

USE CASE 2: Produce a Report of Countries by Continent
CHARACTERISTIC INFORMATION

Goal in Context
As a regional manager, I want to produce a report of all countries in a specific continent so that I can analyse population trends within that region.

Scope
Global Population Reporting System.

Level
Primary task.

Preconditions
Database contains population data and continent names are valid.

Success End Condition
Report of countries within the selected continent is displayed, sorted by population.

Failed End Condition
No report is produced.

Primary Actor
Regional Manager.

Trigger
Manager requests a population report for a specific continent.

MAIN SUCCESS SCENARIO

Regional manager selects “Continent Report”.

System prompts for the continent name.

Manager enters the continent name.

System retrieves all countries within the selected continent.

System displays the report.

EXTENSIONS

Database unavailable → System shows error message.

SUB-VARIATIONS

None.

SCHEDULE

DUE DATE: Release 1.0

USE CASE 3: Produce a Report of the Top N Most Populated Cities
CHARACTERISTIC INFORMATION

Goal in Context
As a population researcher, I want to view the top N most populated cities so that I can focus my studies on the largest urban areas.

Scope
Global Population Reporting System.

Level
Primary task.

Preconditions
Database contains valid city data; user provides a valid integer for N.

Success End Condition
System displays the top N cities by population.

Failed End Condition
Invalid input or no report generated.

Primary Actor
Population Researcher.

Trigger
Researcher requests a “Top N Cities” report.

MAIN SUCCESS SCENARIO

EXTENSIONS

Step 3: Invalid N → System prompts “Please enter a valid number.”

Step 4: Database unavailable → System displays “Error retrieving data.”

SUB-VARIATIONS

SCHEDULE

DUE DATE: Release 1.1

USE CASE 4: Produce a Report on Urban vs Rural Population per Continent
CHARACTERISTIC INFORMATION

Goal in Context
As a data analyst, I want to view the population of people living in and outside cities for each continent so that I can analyse urbanisation rates globally.

Scope
Global Population Reporting System.

Level
Primary task.

Preconditions
Database contains total and city population data for each continent.

Success End Condition
System displays a table of total, urban, and rural population (including percentages).

Failed End Condition
Incomplete or missing data prevents report generation.

Primary Actor
Data Analyst.

Trigger


MAIN SUCCESS SCENARIO

Analyst selects the report type “Urban vs Rural by Continent”.

System retrieves total and city population data for each continent.

System calculates rural population and percentages.

System displays the report.

EXTENSIONS

SUB-VARIATIONS

None.

SCHEDULE

DUE DATE: Release 1.1

USE CASE 5: Produce a Population Report for a Country
CHARACTERISTIC INFORMATION

Goal in Context
As a government advisor, I want to view the total population of a specific country so that I can support national policy decisions.

Scope
Global Population Reporting System.

Level
Primary task.

Preconditions
Database includes the selected country’s data.

Success End Condition
Population of the country displayed.

Failed End Condition
Country not found or data missing.

Primary Actor
Government Advisor.

Trigger
Advisor requests population data for a country.

MAIN SUCCESS SCENARIO

Advisor selects “Country Report”.

Advisor enters a valid country name.

System retrieves country population from the database.

System displays total population.

EXTENSIONS

Step 2: Country not found → System displays “Country not found.”

Step 3: Database error → System shows “Unable to retrieve data.”

SUB-VARIATIONS

None.

SCHEDULE

DUE DATE: Release 1.1

USE CASE 6: Produce a Report of All Capital Cities by Population
CHARACTERISTIC INFORMATION

Goal in Context
As a regional manager, I want to generate a report of all capital cities organised by population so that I can compare administrative city populations.

Scope
Global Population Reporting System.

Level
Primary task.

Preconditions
Database contains valid capital city data.

Success End Condition
Report displayed showing all capitals sorted by population.

Failed End Condition
No report generated or missing data.

Primary Actor
Regional Manager.

Trigger
Manager requests capital city report.

MAIN SUCCESS SCENARIO

Manager selects “Capital City Report”.

System retrieves all capital cities.

System sorts them by population descending.

System displays the report.

EXTENSIONS

Step 2: Missing city data → System shows “No capital cities found.”

SUB-VARIATIONS

None.

SCHEDULE

DUE DATE: Release 1.2

USE CASE 7: Produce a Language Population Report
CHARACTERISTIC INFORMATION

Goal in Context
As a language researcher, I want to generate a report of people who speak specific languages so that I can analyse global language distribution.

Scope
Global Population Reporting System.

Level
Primary task.

Preconditions
Database contains global population and language data.

Success End Condition
Table of languages and their world population percentages displayed.

Failed End Condition
No data retrieved.

Primary Actor
Language Researcher.

Trigger
Researcher requests “Language Statistics” report.

MAIN SUCCESS SCENARIO

Researcher selects “Language Statistics” from menu.

System retrieves total speakers of each target language.

System calculates percentage of world population.

System displays results in a table.

EXTENSIONS

Step 2: Data missing for a language → System displays “Incomplete data for one or more languages.”

SUB-VARIATIONS

SCHEDULE

DUE DATE: Release 1.3

USE CASE 8: Maintain System Access and Data Accuracy
CHARACTERISTIC INFORMATION

Goal in Context
As a system administrator, I want to ensure data accuracy and accessibility so that users can rely on the reports for decision-making.

Scope
Global Population Reporting System.

Level
Primary task.

Preconditions
Admin account exists; system operational.

Success End Condition
System verified and data validated.

Failed End Condition
System errors or outdated data remain unresolved.

Primary Actor
System Administrator.

Trigger
Admin logs in for routine maintenance.

MAIN SUCCESS SCENARIO

Admin logs into the system.

Admin checks for updates to population data.

Admin validates data integrity.

Admin verifies that reports are accessible.

EXTENSIONS

Step 2: Data update fails → System logs error and notifies admin.

Step 4: Report generation fails → Admin investigates system error logs.

SUB-VARIATIONS

None.

SCHEDULE

DUE DATE: Release 1.3
