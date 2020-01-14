# mathematical-expressions-calculator
- All the following operations are solved by recursively sovling left and right subtree of BINARY TREE.
- This program processes mathematical functions in the following ways:
## 1. Evaluate:
- Evaluating Complex Expressions Using Recurssive algorithm in Binary Trees.
- An Expression which is either a Single variables such as “x”, “y”, and “z”, real values or 
- If f and g are expressions then f+g, f-g, f*g, and f/g are also expressions.
- If variables x, y and z are passed as inputs to the program, it does this.
- Eg. Input => Output
- Input: (x+y)*z; 3,4,5 => (3+4)*5 => Output: 35
## 2. Differentiate:
- This routine computes the derivative of a given expression with respect to an indicated variable.
- Eg. The derivative of constant value with respect to x is returned zero.
- if expression is in form of g - h or g + h, it returns g' - h' and g' + h' respectively.
- or else it uses Chain rule (product rule) for g * h which is g'h + h'g and 
- Division rule for g / h which is (g'h - h'g)/(h*h).
## 3. Simplify:
- This routine simpliﬁes a given expression. 
- For example, the derivative of x ∗ y with respect to x will be computed to be: 1 ∗ y + x ∗ 0. This should be simpliﬁed to y.
- it also takes care about 16 special cases involving infinity and zeros such as
- g / 0 = infinity, 0 * h = 0 

============================================================================

### To Compile and run the program: 

1. Create two packages: main and Test.
2. Copy .java file containing code to main.
3. The program should run and compile properly as you pass the different values in calculator.
4. Using GUI, this code can be used to make scientific calculator which can solve DERIVATIVE and complex expression.












