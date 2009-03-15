; Copyright (C) 2008 The Android Open Source Project
;
; Licensed under the Apache License, Version 2.0 (the "License");
; you may not use this file except in compliance with the License.
; You may obtain a copy of the License at
;
;      http://www.apache.org/licenses/LICENSE-2.0
;
; Unless required by applicable law or agreed to in writing, software
; distributed under the License is distributed on an "AS IS" BASIS,
; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
; See the License for the specific language governing permissions and
; limitations under the License.

.source T_dup_x2_7.java
.class public dxc/junit/opcodes/dup_x2/jm/T_dup_x2_7
.super java/lang/Object

.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

.method public run()Z
    .limit stack 5
    .limit locals 2
    
    dconst_1
    iconst_3              ; [1] 3
    dup_x2                ; 3 [1] 3
    
    iconst_3            ; 3 [1] 3 3
    if_icmpne Label2    ; 3 [1]    
    
    dconst_1            ; 3 [1] [1]
    dcmpl                ; 3
    ifne Label1            
    
    iconst_3            ; 0
    if_icmpne Label0    ;    
    
    iconst_1
    ireturn
    
Label2:
    pop2
Label1:
    pop 
Label0:    
    iconst_0
    ireturn
        
.end method
