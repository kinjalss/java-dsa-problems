package com.dsapattern;

public class PrefixSum {
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10};
        int[]prefix=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
           prefix[i]= prefix[i-1]+arr[i];//prev+current
        }
        for(int i=0;i<prefix.length;i++){
            System.out.print(prefix[i]+",");
        }

        int l=1;
        int r=3;
        int sum;
        if(l==0){
            sum=prefix[r];
            System.out.println(sum);
        }
        else{
            sum=prefix[r]-prefix[l-1];
            System.out.println(sum);
        }
        System.out.println();
        System.out.println("Sum from index " + l + " to " + r + " is: " + sum);
    }
}
//YAYYY 😄
//Now you’re ready to actually understand the code deeply instead of memorizing blindly.
//
//Let’s learn the code in the SAME slow way.
//
//---
//
//# Our Array
//
//```java id="z5uc8z"
//arr = [2,4,6,8,10]
//```
//
//Goal:
//
//Create prefix array:
//
//```text id="8p3xxh"
//[2,6,12,20,30]
//```
//
//---
//
//# Full Code
//
//```java id="zxh7eo"
//int arr[] = {2,4,6,8,10};
//
//int prefix[] = new int[arr.length];
//
//prefix[0] = arr[0];
//
//for(int i=1; i<arr.length; i++){
//    prefix[i] = prefix[i-1] + arr[i];
//}
//```
//
//Now let’s understand EACH line slowly.
//
//---
//
//# Line 1
//
//```java id="pwob3o"
//int arr[] = {2,4,6,8,10};
//```
//
//This is the original array.
//
//Memory:
//
//| Index | Value |
//| ----- | ----- |
//| 0     | 2     |
//| 1     | 4     |
//| 2     | 6     |
//| 3     | 8     |
//| 4     | 10    |
//
//---
//
//# Line 2
//
//```java id="ktd4cq"
//int prefix[] = new int[arr.length];
//```
//
//We create a NEW array.
//
//Why?
//
//Because we want to STORE running sums.
//
//Size same as original array.
//
//Initially:
//
//```text id="4jlwmv"
//[0,0,0,0,0]
//```
//
//---
//
//# MOST IMPORTANT FORMULA
//
//```text id="ovr9y7"
//prefix[i] = sum from index 0 to i
//```
//
//Meaning:
//
//| prefix index | stores     |
//| ------------ | ---------- |
//| prefix[0]    | sum till 0 |
//| prefix[1]    | sum till 1 |
//| prefix[2]    | sum till 2 |
//
//etc.
//
//---
//
//# Line 3
//
//```java id="j2j97p"
//prefix[0] = arr[0];
//```
//
//Why?
//
//Because:
//
//```text id="h4m0xj"
//sum till first element
//=
//the first element itself
//```
//
//Array:
//
//```text id="psmwx4"
//[2,4,6,8,10]
//```
//
//So:
//
//```java id="9h7j8r"
//prefix[0] = 2
//```
//
//Now prefix becomes:
//
//```text id="z73h72"
//[2,0,0,0,0]
//```
//
//---
//
//# Now the Loop Starts
//
//```java id="p4o3me"
//for(int i=1; i<arr.length; i++)
//```
//
//Why start from 1?
//
//Because first element already handled.
//
//---
//
//# MAIN MAGIC LINE
//
//```java id="sjf7vt"
//prefix[i] = prefix[i-1] + arr[i];
//```
//
//THIS is the heart of prefix sum.
//
//---
//
//# What Does This Mean?
//
//It means:
//
//```text id="omc24w"
//current prefix
//=
//previous running sum
//+
//current array value
//```
//
//---
//
//# Iteration 1
//
//## i = 1
//
//Formula:
//
//```java id="8rcw4y"
//prefix[1] = prefix[0] + arr[1]
//```
//
//Substitute values:
//
//```java id="c4v33h"
//prefix[1] = 2 + 4
//          = 6
//```
//
//Now:
//
//```text id="64v0x7"
//[2,6,0,0,0]
//```
//
//---
//
//# What does 6 mean?
//
//```text id="3uxkbo"
//sum from index 0 to 1
//```
//
//Which is:
//
//```text id="igk10q"
//2 + 4
//```
//
//---
//
//# Iteration 2
//
//## i = 2
//
//Formula:
//
//```java id="a8xejw"
//prefix[2] = prefix[1] + arr[2]
//```
//
//Substitute:
//
//```java id="bdv0n9"
//= 6 + 6
//= 12
//```
//
//Now:
//
//```text id="o0q3qt"
//[2,6,12,0,0]
//```
//
//---
//
//# What does 12 mean?
//
//```text id="zupg3f"
//sum from index 0 to 2
//```
//
//Which is:
//
//```text id="swjlwm"
//2 + 4 + 6
//```
//
//---
//
//# Iteration 3
//
//## i = 3
//
//```java id="j4t3k9"
//prefix[3] = prefix[2] + arr[3]
//```
//
//Substitute:
//
//```java id="51kr4f"
//= 12 + 8
//= 20
//```
//
//Now:
//
//```text id="fv6ftg"
//[2,6,12,20,0]
//```
//
//---
//
//# Iteration 4
//
//## i = 4
//
//```java id="9z93rp"
//prefix[4] = prefix[3] + arr[4]
//```
//
//Substitute:
//
//```java id="2b2r43"
//= 20 + 10
//= 30
//```
//
//Final:
//
//```text id="7w5r2n"
//[2,6,12,20,30]
//```
//
//DONE.
//
//---
//
//# IMPORTANT UNDERSTANDING
//
//Notice this:
//
//```text id="n9ol94"
//prefix[i-1]
//```
//
//already contains OLD SUM.
//
//So we don't calculate again from beginning.
//
//We simply add ONE new number.
//
//That is optimization.
//
//---
//
//# VISUAL FLOW
//
//```text id="0w1ujh"
//prefix[0] = 2
//
//prefix[1] = 2 + 4 = 6
//
//prefix[2] = 6 + 6 = 12
//
//prefix[3] = 12 + 8 = 20
//
//prefix[4] = 20 + 10 = 30
//```
//
//Each step uses PREVIOUS ANSWER.
//
//---
//
//# Why Efficient?
//
//WITHOUT prefix:
//
//To calculate till index 4:
//
//```text id="ln1txh"
//2+4+6+8+10
//```
//
//Again and again.
//
//---
//
//WITH prefix:
//
//Already stored.
//
//Just use:
//
//```text id="uxn0pv"
//prefix[4]
//```
//
//Instant answer.
//
//---
//
//# Now Range Sum Formula
//
//Suppose:
//
//```text id="b5s6a0"
//Find sum from index 1 to 3
//```
//
//Meaning:
//
//```text id="63rj24"
//4 + 6 + 8
//```
//
//Formula:
//
//```text id="gm5qg8"
//sum = prefix[r] - prefix[l-1]
//```
//
//Where:
//
//| Variable | Meaning          |
//| -------- | ---------------- |
//| l        | left/start index |
//| r        | right/end index  |
//
//Here:
//
//```text id="26lrqb"
//l = 1
//r = 3
//```
//
//So:
//
//```text id="v7i91g"
//sum = prefix[3] - prefix[0]
//```
//
//Substitute:
//
//```text id="2oik8x"
//= 20 - 2
//= 18
//```
//
//Correct answer.
//
//---
//
//# Why Subtraction Works
//
//Because:
//
//```text id="zl76s7"
//prefix[3]
//```
//
//contains:
//
//```text id="t2vqxf"
//2 + 4 + 6 + 8
//```
//
//And:
//
//```text id="o7fe2u"
//prefix[0]
//```
//
//contains:
//
//```text id="g0qhqs"
//2
//```
//
//Subtract unwanted part:
//
//```text id="5nl0b3"
//(2+4+6+8) - (2)
//```
//
//Remaining:
//
//```text id="8y6nlj"
//4+6+8
//```
//
//Magic complete 😄

//https://chatgpt.com/share/6a06796c-8c54-8324-b91c-6795b962d2d3