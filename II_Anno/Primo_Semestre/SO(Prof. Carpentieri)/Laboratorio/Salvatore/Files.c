#include <stdio.h>
#include <ctype.h>
#include <unistd.h>
#include <fcntl.h>


#define SIZE 256

int main()
{
	FILE *F1, *F2;
	
	char nomeF1[64];
	char nomeF2[64];
	
	printf("file da leggere\n");
	scanf("%s", nomeF1);
	
	int DescriptorF1= open(nomeF1, O_RDONLY);

    if (DescriptorF1 == -1) 
    {
        perror("Error opening the file");
        return 1;
	}
	
	char FileLetto[SIZE];
	
	int ByteLetti = read(DescriptorF1, FileLetto, SIZE);
	    
	if (ByteLetti == -1) 
	{
        perror("Error reading from the file");
        close(DescriptorF1);
        return -1;
	}
	
	printf("file dove copiare\n");
	scanf("%s", nomeF2);
	int DescriptorF2 = open(nomeF2, O_WRONLY);
	
	if (DescriptorF1 == -1) 
    {
        perror("Error opening the file");
        return 2;
	}
	
	char DaScrivere[SIZE];
	
	int ByteScritti = write(DescriptorF2, DaScrivere, SIZE);
	
	if(ByteScritti == -1)
	{
		perror("Error reading from the file");
        close(DescriptorF2);
        return -2;
	}
    
    while(ByteLetti > 0)
    {
    	int i = 0;
    	while(FileLetto[i] != '\0')
    	{
    		if(islower(FileLetto[i] != 0)) //è lower case
    		{
    			DaScrivere[i] = toupper(FileLetto[i]);
			}
			else
			{
				DaScrivere[i] = tolower(FileLetto[i]);
			}
    		i++;
   		 }
   		 
   		 //scrivo il contenuto invertito
		 ByteScritti = write(DescriptorF2, DaScrivere, i);
		 if(ByteScritti == -1)
		 {
		 	 perror("Error reading from the file");
         	 close(DescriptorF2);
        	 return -2;
		 }
		 
		 //leggo nuovamente
		 ByteLetti = read(DescriptorF1, FileLetto, SIZE);
   		 if (ByteLetti == -1) 
		 	{
         	perror("Error reading from the file");
         	close(DescriptorF1);
         	return -1;
			}
   	}
	close(DescriptorF1);
	close(DescriptorF2);
	return 0;
}
