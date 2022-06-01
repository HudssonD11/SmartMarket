#include <stdlib.h>
#include <stdio.h>
#include "myString.c"
#include <string.h>

int main(int argc, char** argv)
{
    if(argc>2)
    {
        string file = sl_copyString(argv[1]);
        file = sl_concat(file, " ");
        file = sl_concat(file, argv[2]);
        string comando = "cd ../service && /usr/lib/jvm/java-11-openjdk-amd64/bin/java -Dfile.encoding=UTF-8 -classpath /home/hudsson/Documentos/cc/s2/ti2/service/target/classes:/home/hudsson/Downloads/Tess4J/lib/lept4j-1.6.4.jar:/home/hudsson/Downloads/Tess4J/lib/jai-imageio-core-1.4.0.jar:/home/hudsson/Downloads/Tess4J/lib/pdfbox-tools-2.0.9.jar:/home/hudsson/Downloads/Tess4J/lib/pdfbox-2.0.9.jar:/home/hudsson/Downloads/Tess4J/lib/jbig2-imageio-3.0.0.jar:/home/hudsson/Downloads/Tess4J/lib/fontbox-2.0.9.jar:/home/hudsson/Downloads/Tess4J/lib/commons-io-2.6.jar:/home/hudsson/Downloads/Tess4J/lib/logback-core-1.2.3.jar:/home/hudsson/Downloads/Tess4J/lib/logback-classic-1.2.3.jar:/home/hudsson/Downloads/Tess4J/lib/jboss-vfs-3.2.12.Final.jar:/home/hudsson/Downloads/Tess4J/lib/slf4j-api-1.7.25.jar:/home/hudsson/Downloads/Tess4J/lib/log4j-over-slf4j-1.7.25.jar:/home/hudsson/Downloads/Tess4J/lib/jul-to-slf4j-1.7.25.jar:/home/hudsson/Downloads/Tess4J/lib/jcl-over-slf4j-1.7.25.jar:/home/hudsson/Downloads/Tess4J/lib/jna-4.1.0.jar:/home/hudsson/Downloads/Tess4J/lib/ghost4j-1.0.1.jar:/home/hudsson/Downloads/Tess4J/lib/commons-logging-1.2.jar:/home/hudsson/Downloads/Tess4J/lib/commons-beanutils-1.9.2.jar:/home/hudsson/Downloads/Tess4J/lib/junit-4.12.jar:/home/hudsson/Downloads/Tess4J/lib/hamcrest-core-1.3.jar:/home/hudsson/Downloads/Tess4J/lib/log4j-1.2.17.jar:/home/hudsson/Downloads/Tess4J/lib/xmlgraphics-commons-1.5.jar:/home/hudsson/Downloads/Tess4J/lib/itext-2.1.7.jar:/home/hudsson/Downloads/Tess4J/dist/tess4j-3.4.8.jar service.Principal ";
        comando = sl_concat(comando, file);
        comando = sl_concat(comando, " > teste.txt");
        system(comando);
        //char* file = (char*) malloc()
        //system("touch ");
    	//string retorno = sl_copyString(system(comando));
        //char* retorno = (char*)malloc(2048);
        //strcpy(retorno, system(comando));
        //*retorno = system(comando);
        //printf("\n\n%s\n\n\n%s\n",file, comando);
//        FILE * arquivo = fopen("teste.txt", "wt");
//        fprintf(arquivo, "%s", retorno);
//        fclose(arquivo);

    }
	return 0;
}
