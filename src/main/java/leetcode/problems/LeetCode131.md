# note

状态转移方程的依赖关系， 决定了遍历的方向

aabbccpoopc

[true, true, false, false, false, false, false, false, false, false, false]  
[true, true, false, false, false, false, false, false, false, false, false]  
[true, true, true, true, false, false, false, false, false, false, false]  
[true, true, true, true, false, false, false, false, false, false, false]  
[true, true, true, true, true, true, false, false, false, false, false]  
[true, true, true, true, true, true, false, false, false, false, true]  
[true, true, true, true, true, true, true, false, false, true, false]  
[true, true, true, true, true, true, true, true, true, false, false]  
[true, true, true, true, true, true, true, true, true, false, false]  
[true, true, true, true, true, true, true, true, true, true, false]  
[true, true, true, true, true, true, true, true, true, true, true]  