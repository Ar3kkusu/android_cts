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

.source T_invokestatic_15.java
.class public dxc/junit/opcodes/invokestatic/jm/T_invokestatic_15
.super java/lang/Object


.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method



.method public run()Z
    .limit stack 2
    .limit locals 3

    bipush 123
    istore_1

    sipush 345
    istore_2

    sipush 12
    sipush 6
    
    invokestatic dxc/junit/opcodes/invokestatic/jm/TestClass/testArgsOrder(II)I

    iconst_2
    if_icmpne Label0

    iload_1
    bipush 123
    if_icmpne Label0

    iload_2
    sipush 345
    if_icmpne Label0

    iconst_1
    ireturn

Label0:
    iconst_0
    ireturn
.end method
