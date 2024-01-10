# Hospital Information System

## Preface and Instruction

This back-end development project was developed by my team and I in 2022 for a public hospital in China. The entire software development cycle is xx months. [VUE](https://vuejs.org/), JAVA etc. are used.

After the development of the project was completed, I returned to the United States. I refactored all the previous code and changed it to the English version for everyone's learning and own code archiving.

**Current version: 1.0** (updated in Jan 2024)

>1. Run his-java application
>
>2. Use `npm run serve` start his-web
>3. Click link in web storm or Use localhost://8080 to access

## Development Background

China's hospital system has continuously upgraded hospital information management systems over the past 20 years. A more humane and intelligent information management system benefits both medical staff and patients, improving overall efficiency. 

Typically, hospital visits in China are much the same as in Western countries. But there are still differences. For example, most hospitals in China will settle the account immediately instead of mailing bills later. The process of seeing a doctor in a Chinese hospital is roughly as follows.



![MedicalTreatmentProcess]([./src/Medical Treatment Process.png](https://github.com/fykkyf/his-java/blob/master/src/Medical%20Treatment%20Process.png))



This customized hospital information management system mainly implements the following key points:

1. Enter the information of each department of the hospital and store it in the SQL database.

2. Each department has different permissions to retrieve patient information.

3. Achieve information reading between various departments, schedule reservations, etc.

4. Realize joint diagnosis and information exchange between special departments.

5. Because the medical treatment process must be rigorous and the operations of most departments are highly interrelated, usually all the prerequisites required for an operation must be met before the operation can be performed correctly.
