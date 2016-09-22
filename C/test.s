.data

.text
  .globl main

main:
  li    $a0, 1
  li    $a1, 2
  jal foo
  # do whatever i want with $v0 = $a0 + $a1
  j exit

foo:
  add   $v0, $a0, $a1
  jr    $ra

exit:
  li $v0, 10    # exits the program
  syscall
