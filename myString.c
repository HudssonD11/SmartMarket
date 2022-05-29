#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef char* string;

string sl_newString(int n)
{
	string result = (string)malloc((n+1)*sizeof(char));
	result[0] = '\0';
	return (result);
}

int sl_length(string line)
{
	int result = 0;
	for(int i=0; line[i]!='\0' && (line+i)!=NULL; i++)
	{
		result++;
	}
	return result;
}

string sl_copyString(string line)
{
	int len = sl_length(line);
	string result = sl_newString(len);
	for(int i=0; i<len; i++)
	{
		result[i] = line[i];
		result[i+1] = '\0';
	}
	return result;
}

string sl_concat(string a, string b)
{
	int tamA = sl_length(a);
	int tamB = sl_length(b);
	int tam  = tamA + tamB;
	string c = sl_newString(tam);
    for(int i=0; i<tamA; i++)
    {
		c[i] = a[i];
		c[i+1] = '\0';
    }
	for(int i=tamA, j=0; i<tam; i++)
	{
		c[i] = b[j++];
		c[i+1] = '\0';
	}
	return c;
}

string sl_subString(string a, int inic, int fim)
{
	string result;
	if(a!=NULL && fim<=sl_length(a) && fim>=0 && inic<=fim && inic>=0)
	{
		result = sl_newString(fim - inic + 1);
		for(int i=inic, j=0; i<=fim; i++)
		{
			result[j++] = a[i];
			result[j] = '\0';
		}
	} else
	{
		result = sl_newString(0);
	}
	return result;
}

bool equals(string a, string b)
{
	bool result = false;
	int tamA = sl_length(a);
	int tamB = sl_length(b);
	if(tamA==tamB)
	{
		result = true;
		int i = 0;
		while(i<tamA && result)
		{
			result = (a[i] == b[i]);
			i++;
		}
	}
	return result;
}

bool contains(string a, string b)
{
	bool result = false;
	int tamA = sl_length(a);
	int tamB = sl_length(b);
	if(tamA>=tamB)
	{
		int tam = tamA-tamB;
		for(int i=0; i<tam; i++)
		{}

	}
	return result;
}
/*
int main ()
{
	string line = sl_newString(5);
	line[0] = 'a';
	line[1] = 'b';
	line[2] = 'c';
	line[3] = 'd';
	line[4] = '\0';
	string line2 = sl_copyString(line);
	printf("%s\n%s\n", line, line2);
	return 0;
}
*/