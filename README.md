# Sum It Up User's Guide

## How to Run
### 1. use `run.bat`
We recomand you to use `run.bat` in root folder to run the program.   
It will automatically compile and run the program.   
If you want to run the program with your own test case, you can modify the `run.bat` file. The `run.bat` file is as follows:

```bat
javac src\SumItUp.jav
move src\SumItUp.class .\SumItUp.class
dir
java SumItUp
```

### 2. use `javac` and `java`
If you want to run the program with your own test case, you can use `javac` and `java` command to compile and run the program.
    
```bat
javac src\SumItUp.java
java SumItUp
``` 
**Note that** you may lose the image of the program if you use this method.  
So make sure you copy the `img` folder to the folder where `.class` file is located.

> i.e.   
> You can move the `SumItUp.class` file to the root folder, and then run the program with `java SumItUp` command.

# How to Use
When you run the program, you will see the following interface:

<div align=center>
<img src="https://dsm04pap003files.storage.live.com/y4mvTN0Ee-LZjWOk1EfqgF0EkWrbdHMHw025KRfl2zUbWXTfHX8MVfbMHZcPIKH-1qd1M34xEACwAF9s4XNqf5ZNSolGAzGZRKuHX5KBRkuyZ6zJf8l_2T2_PQVS5lfyYjAY8QCMwIQ62XsjSz3iZ2m3coKWcEfQksoDw0w5Gvp0GeEQCYHHHrrJUhoIfiDkYnQ?width=512&height=480&cropmode=none" width="512" height="480" />
</div>

## Type your input
You are supposed to type your input in the text field. The number depends on the number of rabbits displayed on both sides.  
And you need to sum them up to get the total number of rabbits and type it in the third text field.

## Check your answer
After you type your answer, you can click the `Check` button to check your answer.  

<div align=center>
<img src="https://dsm04pap003files.storage.live.com/y4m5hurCb-gAv5YBhVzR25y4wE2Aim_-p1PPCcWdF0JAowY_Q6c_ewKcVDjN_ya_1aU_Q0dpMcHctZiX7J0srLFHXn61xALc_6gDsnEiAivJsI79RXy2zVc-z-eaVvTjeMFETZCp3nTS5wKEpzvJjEflNFP2d0-YbCbEU5xKdEy5KoSjV1hc2RWfrJbU1XpL1TR?width=512&height=480&cropmode=none" width="512" height="480" />
</div>

If your answerer is right, you will see the following interface, and go into the next question:

<div align=center>
<img src="https://dsm04pap003files.storage.live.com/y4muWv93UM_004FU1__IHeOeweBmQdOodWtS8K2ltWnegrmdqFSRuGyIE7BxQJInPBhhvEJK1b5kKBvcFF-NtwFAUN9pSDcl_u5CmVtu0rC-52r-q1kiii8Fth5KYEocyXaXhyzb9kDDr7nXg-Yw_QM9xv6SVNUJUMFrkDIEXmwZScyLJrYDtfU3CdKG80CmulP?width=512&height=480&cropmode=none" width="512" height="480" />
</div>

Or your answer is wrong, you will see the following interface, and you can try again:

<div align=center>
<img src="https://dsm04pap003files.storage.live.com/y4m0BGiCYZD_kMWcEoUnY7sCF0TV_rVFyJY8hXByZYqicDFp-amaT2SMKxX2JpbbLCZu4QG3YKuFhCDTw20w4_N8hWYaW0s04fdDsPQrJKwMRLuEbcEMmNIKxjT1dfJBB8_eikFLrllS-B1JDlIr_q8mdF_WqJVWzEuumsoSFO8uyklO1L9TviVbyWFJBAe_3Ke?width=512&height=480&cropmode=none" width="512" height="480" />
</div>

# Close the program
You can click the `Close` button (i.e. the `X` button) to close the program.
