public class Paninoteca 
{
    private int NumeroPanini;
    private List<String>
}



CREATE TABLE 'gareggiare'
(
    Nome_Gara VARCHAR(100) NOT NULL,
    Nome_Squadra VARCHAR(100) NOT NULL,

    PRIMARY KEY ('Nome_Gara'),
    PRIMARY KEY ('Nome_Squadra'),

    FOREIGN KEY ('Nome_Gara') REFERENCES 'Gara' ('Nome'),
    FOREIGN KEY ('Nome_Squadra') REFERNECES 'Squadra' ('Nome'),
)