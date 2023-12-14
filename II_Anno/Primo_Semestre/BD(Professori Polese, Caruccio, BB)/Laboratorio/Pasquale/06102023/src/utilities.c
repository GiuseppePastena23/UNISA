#include "utilities.h"
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool is_file_empty(FILE *fp)
{
    int c = fgetc(fp);
    if (c == EOF)
    {
        return true;
    }
    else
    {
        ungetc(c, fp);
    }
    return false;
}
