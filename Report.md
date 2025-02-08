# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for?
   >Comma-Separated Values

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
    >First List<IEmployee> can store the subclasses of IEmployee,ArrayList<HourlyEmployee> can only store HourlyEmployee. Second if I change the list type to linked list, I dont need to change the signature.
3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?
    >it is has-a relationship or composition
4. Can you provide an example of a has-a relationship in your code (if one exists)?
    >employee has a name, ID, ...

5. Can you provide an example of an is-a relationship in your code (if one exists)?
    >SalaryEmployee is an Employee or HourlyEmployee is an Employee

6. What is the difference between an interface and an abstract class?
    >usually interface has only signatures(although can use keyword "default" to write method body) and can have multiple inheritance, abstract class contains method bodies(or use"abstract" to include just the signature ), and can only do one inheritance

7. What is the advantage of using an interface over an abstract class?
    >interface can have multiple inheritance, and more flexible by just declare method signature 

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 
 >not valid, int is a primitive type, should use the object version Integer like List<Integer> numbers = new ArrayList<Integer>();

9. Which class/method is described as the "driver" for your application? 
>PayrollGenerator class, main()


10. How do you create a temporary folder for JUnit Testing? 
> using @TempDir, static Path tempDir in the TestPayrollGenerator

## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 
>To solve this problem, we should focus on equality in the workplace. Many women are underpaid nowadays. According to Caroline Colvin: “An area of particular concern is science, technology, engineering and mathematics. A recent report, Women in STEM: A Quest for Equity, suggested that while half of women in STEM have received a raise in the last year, about 25% have never received one. Likewise, 45% of women in STEM say they have never received a promotion.” Similarly, the income gap also exists in different ethnicities. According to Ian Davies:” In 2023, our research showed that STEM professionals in the UK from Mixed/Multiple ethnic backgrounds earned just £891 below their White co-workers, while Black professionals earned £7,951 below their White co-workers and Asian professionals earned £16,297 below their White co-workers.” This phenomenon might be due to a variety of reasons. The problem is that, in most cases, we have no idea exactly why. We can solve this issue by making our payment system more transparent. Improve our pay system by collecting more data categories such as gender, race, years of experience, job role, job performance, and education level. By analyzing these data, we can identify the causes of income mismatch. We then need to consider the impact of pre-tax benefits to get to the root of the problem. By addressing wage inequality, we can create an environment where all employees feel valued and want to contribute. A fair payroll system should reward employees based on their work performance rather than race or gender.


>https://www.hrdive.com/news/women-in-stem-career-progression/709503/
> 
>https://www.srgtalent.com/blog/gender-and-ethnicity-pay-gap-breaking-down-stem-pay-inequalities
