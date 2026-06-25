# JAVA_FSE

Digital Nurture Java FSE exercise solutions.

## Week 1

- `deepskilling/week_1/algorithms`: Algorithms and Data Structures exercises 1 to 7.
- `deepskilling/week_1/design_patterns`: Design Patterns and Principles exercises 1 to 11.
- `deepskilling/week_1/plsql`: PL/SQL programming exercises 1 to 7.

Compile the new solutions from the repository root:

```powershell
javac -d out (Get-ChildItem deepskilling\week_1\algorithms,deepskilling\week_1\design_patterns -Filter *.java -Recurse).FullName
```

Run any exercise by using its package name, for example:

```powershell
java -cp out deepskilling.week_1.algorithms.Exercise01InventoryManagement
java -cp out deepskilling.week_1.design_patterns.Exercise01Singleton
```

Run the PL/SQL solutions from SQL*Plus or SQL Developer:

```sql
@deepskilling/week_1/plsql/plsql_exercises_solutions.sql
```
