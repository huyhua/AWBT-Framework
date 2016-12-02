* ACTION DEFINITION			my action	
* DESCRIPTION				This is user action.
...							line two.
...							line three.

#							name					default value				description
argument					user					khoi						this is argument to store user name
argument					greeting				Hello						
argument					age						n/a							

#							text
log to console				${greeting} ${user}
log to console				Now, you are ${age}