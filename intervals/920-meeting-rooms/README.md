<h2><a href="https://www.lintcode.com/problem/920/">Meeting Rooms</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-Green' alt='Difficulty: Easy' /><hr>

## Description
Given an array of meeting time intervals consisting of start and end times `[[s1,e1],[s2,e2],...] (si < ei)`, determine if a person could attend all meetings.

`(0,8),(8,10)` is not conflict at `8`

## Example

### Example1

`Input:` intervals = `[(0,30),(5,10),(15,20)]`
<br>
`Output:` `false`
<br>
Explanation: 
`(0,30), (5,10)` and `(0,30),(15,20)` will conflict

### Example2

`Input:` intervals = `[(5,8),(9,15)]`
<br>
`Output:` true
<br>
Explanation: 
Two times will not conflict 


