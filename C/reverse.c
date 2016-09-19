#include<stdio.h>

void rev(char* string) {
  int len = 0;
  while(string[len]) {
    len++;
  }
  for(int i = 0, k = len - 1; i < (len/2); i++, k--) {
    char temp = string[k];
    string[k] = string[i];
    string[i] = temp;
  }
}

int main(int argc, char* argv[]) {
  char* string = argv[1];
  rev(string);
  printf("%s", string);
  return 0;
}
