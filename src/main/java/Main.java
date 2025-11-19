import java.util.List;
import java.util.Scanner;
/*

Autor: Andrihu
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKOkxddddooddooodddxkO0KXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOxlc;;;;;;;;;;::::;;;;;;;;;:codk0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN0dc:;;;:ccccccccccccc::ccccccccc::;;;:lx0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOdc;;:cccccccccccccccccccccccccccccccccc:;,;:okXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dc;;cccccccccllccccccccccccccccccccccccccccc:::,,:oONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOl;;cllllclccllllllcccccccccccccccccccccccccccc:::::;,,cONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOl;:cllllllllllllllllccccccccccccccccccccc:cccccc::::::::;,cOWMMWNNXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0l;:clllllllllllllllllllllcccllccccccccccccccccccc:::::::::::;,lxdol::clx0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXd;:cllllllllllllllllllllllllcccllcccccccccccccccccc::::::::::::,.,;;::::;,;l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNk:;clllllllllooollllllllllccclccclccccccccccccccccccc:::c:::::::;',:;;:::::;;,;dNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMKl;:lllllllllloooollllllllllccccccllccccccccccccccccccccccc:::::::'';,;:::::cc:;,,lKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWk:;cllllllllllllllllllllllccllccccclllccccccccccccccccccc:::::::::;',;,:::::::cc:;,':0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNd;:llllllllllllllllllllllllccccccccllllccccccccccccccccccc:::::::::,':;;::::::ccccc;;,:0MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXo;:llllllllllooollllllllllllccccccllllllcccccccccccccccc::::::::::::,,:;;:::::::cccc:;;,lNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMWXkddxKWMMMMMMMMMMMMMW0c,cllllllllllooolllllllllllllllllclllllllccccccccccccccc:::::::::::::,':;,;;:::::ccccc::,;OMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMM0c,;;,;dNMMMMMMMMMMMXd;;cllllllllllllllllllllllllllllllllllllcccccccccccccccccc::::::::::::;'.;::;;,,,;;:::;;::,:0MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMWx;;:cc;,cOWMMMMMMMNk:,:lllllllllllllloollllllllllllllllccccccccccccccccccccccccc:ccc::::::;',;::c::::;;;;;;;::,;xWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMWd;;;ccc:;;l0WMMMNOc;:lllllllllllllloooolllllllccllccccccccccccccccccccccc:::::ccccccccccc;,;cccc:;,,,,,;;,,,'':OWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMWd;:;:cccc:;;oOKkc;:llllllllllllooooollllllccc::cccccccccccccccccccccccccc:::::::ccccccc:;;:ccccc:::;,.',,,,,;,;xNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMWx;:;:ccccc::;',,:clllllllllllloollllc:;;,,'''''',;:cccccccccccccccccccc:::::::cccccccc:::cccccc:::::,,::::;;;;;;xWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMk::;;ccccc:,,;:clllllllllllllllllc;,'''',,,,'',''..';:cccccccccccccccc:::::::ccccccccccccccccc::::::;;:::::;:;;,;kWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMKc;;;ccc:;..;lllllllllllllloollc;'',,,,,,,,,''''''''..,:cccccccccccccc::::::::ccccccccccccccc::::::::::::;:::::;,:0MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMWx;,;cc;'....,clllllolloollool:''',,'''',,,,,''''...''.',:c:cccc:::::c::::::::::::cccccc::::::::::::::::;;::::;;;,lXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMNOlcccc,..''.';llloooooooooll,''''',;;:clllc::;;;;,,''..,:::ccc:::::::::::::::::ccc:::::::::::::::::::::::::;:::;,dNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXXNXl',''...,looooooooollc,.',;:ccllllllllcccccccc:;;;:::c::::::::::::::::::::ccc:cc:::::::::::::::::::::::;;:;,dNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMKl:llc;,'.,clooooooollc,,:ccclllccllllllccccccccccccc::::::::::::::::::::::ccccccc:::::::::::::::::::::;;;;;;,lKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM0::lllllc;;::loooooolllccccccccccclllcccccccccccccccc:::::::::::::::::::cc:::ccccc:::::::::::::::::::::::::;;;,:OWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMKc:llllllccc::cllllllllcccccccccccllcccccccccccccccccc::::::::c::::::cccccc:ccccccc:::::::::::::::::::::::::::;,,dNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNo;clllllcclcc::cllllllcccccccccc::ccccccccccccccccccc:::::::::ccccccccccccccccccccc::::::::::::::::::::::::::::;,c0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO::llllccccccc:;clllllcccccccccc;;cccccccllccccc:cc::::::::ccccccccccccc:ccccc:cccc:::::::::::::::::::::::::::::;,;dXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNd,:lllcccccccc;;clllcccccccccc:,;c:;,,;;;;;;;;;:::::ccccccccccccccccc::::cccc:ccc::::::::::::::::::::::::::::::::;,:o0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXd;:clllllcccc:,;llllccccccccc:,..   ,ooolcc::;;;;:::ccccccccccccccccc::ccccccccc:::::::::::::::::::::::::::;:::::;;,;:okKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0c',,,,;;;;:c;,cllllcccccccc:,.    :kkkxxdddoolc::cccccccccccllcccccccccccccccc:::::::::::::::::::::::;;:::::::;;;;:;,,;cox0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMk'   .;lcc::;,clllllccccccc;,.   .okxxxxdddooolccccccccllllllllccccccccccccc:::::::::::::::::::::::::;;:::::::;::;:;;;;;,',cox0KNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMk'   .lkxxxdc,:llllllcccccc:,,,.,lxkxxxdddoolc:ccc::lllllccccccccccccccccc::::::::::::::::::::::::::::::::::::::::::::;;;;;;,,,;:ok0NWMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNo'.  'dxxxddl;:lloollllccccc:;;:clloollllcc:::cc:::cllllccccccccccccccccc::::::::::::::::::::::::::::::::::::::::;;;;;;;;;;;;;;;;,,;:lkXWMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWk:;,':oxxxdddc;:llooolllcccccc:;::::::;;;::cc:;;::clllllcccccccccccccccc:::::::::::::::::::::::::::::::::::::::::::::;;;;;;;::;;;;;;;;,,:o0WMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKo.'cc:clllcc::,;lllllllllcccccc::::;;;::;;;;;:::cloooolllccccccccccccccc::::::::::::::::::::::::::::::::::::::::::::::::;;;;;;;;;;:::;::;;,,lONMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNk;..:ll::::;;;;,,clllllllllcclcccccccc:::::::clllllooooolllllcccccccccccccc::::::::::::::::::::::::::::::::::::::::::::::::::;;;;;;;;::;;;;;;;,,cdxkO0KXNWWWMMMMMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0c'..'cooc:::::ccccllllllllccccccccccccclllllcccllooooooolllllllccccccccccccc:::::::::::::::::::::::::::::::::::::::::::::;;:::::;;;;;;;;;;;;;;;;;'.....',;::cllllloodd
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKo'....'loollllllllllllllllccccccccccccccclllllccllooooooollllllllccccccccccccc:::::::::::::::::::::::::::::::::::::::::::::;;::::;;;;;;;;;;;;;;;;;;;'...................
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMWO;......'looollcllllllllllllcccccccccccc::cclllllllloooooollllllllccccccccccccccc::::::::::::::::::::::::::::::::::::::::::::::::;;;;;;;;;;;;;;;;;;;;:,...................
MMMMMMMMMMMMMMMMMMMMMMMMMMMMM0;.......'cooolccloooooooolllcccccccccccc:;;:ccllllllllllllllllllllcccccccc::cccccc:::::::::::::::::::::::::::::::::::::::::::::::;;;;;;;;;;;;;;;;;;;;:,...................
MMMMMMMMMMMMMMMMMMMMMMMMMMMMKc.........:oolcclooooooooolllccccccccccccc::;;:cllllllllllllllllllllccccccccccccccccc::::::::::::::::::::::::::::::::::::::::;;:::;;;::;;;;;;;;;;;;;;;:,...................
MMMMMMMMMMMMMMMMMMMMMMMMMMMNo.......'..;ooc:cooooollllllllcccccccccccc::::;,;cccllllllllllllccllccccc:ccccccccccccc::::::::::::::::::::::::::::::::::::::::::::;;;;;;;;;;;;;;;;;;;;;'...................
MMMMMMMMMMMMMMMMMMMMMMMMMMWk,.......''.'co::lollllllllllllccccccccccc:::::::,,clllllllllllllccccccccccccccccc:ccccc:cc:::::::::::::::::::::::::::::::::::::::::;;;;;;;;;;;;;;;;;;;;,....................
MMMMMMMMMMMMMMMMMMMMMMMMMMNl........''..,l:;llllllllllllllcccccc::;;,,;::::::,;lllllllccclcccccccccccccccccccccccccc::::::::::::::::::::::::::::::::::::::::::::;;;;;;;;;;;;;;;;:;;.....................
MMMMMMMMMMMMMMMMMMMMMMMMMMXc........'''..;c;:lollllllllllcccc::,...   .,::::;',cclllllcclcccccccccccccccccccccccc:::::::::::cc::::::::::::::::::::::::::::::::::;;;;;;;;;;;;;;;;;;......................
MMMMMMMMMMMMMMMMMMMMMMMMMMO,........''''..;:;clllllllllccccc:;,...   ..;:::c:;:ccllllcccccccccccccccccccccccccccc:::ccc:ccccc:::::::::::::::::::::::::::::::::::::;;;;;;;;;;;;;:;.......................
MMMMMMMMMMMMMMMMMMMMMMMMMKc........''''''..,:;;cc::::ccccccc::::;;;;;;::::cclllllllllcccccccccccccccccc::ccccccccc::cccccc:::c:::::::::::::::::::::::::::::::::::;;;;;;;;;;;;;:;........................
MMMMMMMMMMMMMMMMMMMMMMMMKlc,.......'''''''..'::;;,,,,',;:cccccc::::::ccccclllllllcc:::cccccccccccccccccccccccccccccccccccc::cc::::::::::::::::::::::::::::::::::;;;;;;;;;;;;;;,.........................
MMMMMMMMMMMMMMMMMMMMMMW0llxc......'''''''''...;clc:;;;,,;;:cccccccccccclllllllllllcc::;;;:cccccccccccccccccccccccccccc::::::ccc::::::::::::::::::::::::::::::::::;;;;;;;;;;;:,.'........................
MMMMMMMMMMMMMMMMMMMMMWOclkkl.....'''...''''''...:loollllcccccccclllllllllllccllllllcccc:;;;;:ccccccccccccccccccccccccccc::::cc:::c:::::::::::::::::::::::::::::::;;;;;;;;;;;,.,'........................
MMMMMMMMMMMMMMMMMMMMWOcokOOo'..''''...''''...''..;looollllllllllllllllllllccccccllcccccccc:;,,,;:ccccccccccccccccccccccccccccc::::::::::::::::::::::::::::::::::;;;;;;;;;;;'';;..........'''''..........
MMMMMMMMMMMMMMMMMMMM0clkOOOl..'''''...'''''..'''..:ooooooooooooollllllllllllllcclcccccccccccc:;,,,,;::cccccccccccccccccccccccc:::::::::::::::::::::::::::::::::::;;;;;;;;;''::...................'......
MMMMMMMMMMMMMMMMMMMKllkkkOk:..'''''...''''.....''.'cooooooooooooooollllllllllllcccccccccccccccccc:;,,,,:cccccccccccccccllccccc:::::::::::::::::::::::::::::::::;:;;;;;;:,.':;..................''''.....
MMMMMMMMMMMMMMMMMMXolkOkkkd,.'''''''.'''''''...'''.,looooooooooooooooolllllllllccccccc:ccccccccccccc::,,,;cccllccccccllllcccc::::::::::::::::::::::::::::::::::::;;;;;;,.,:'...................'''......
MMMMMMMMMMMMMMMMMWxcxkkkkkl..'''''''''''''''....'''.,loooooooooooooooolllllllcccccccc::cccccccccccccccc:;,,:lllllcccccccccccc::::::::::::::::::::::::::::::::::::::;:;''::'.....................'''''...
MMMMMMMMMMMMMMMMM0cokkkkkk:..'''''''''''..''....'''..;looooooooooooooolllllccccccccc::::cccccc::::cccccccc,,:lllllllccccccccc::::::::::::::::::::::::::::::::::;;::;,.,c:.......................'''''...
MMMMMMMMMMMMMMMMNockOkkkkx;..'''''''''''..'.'....'.'..,looooooooooooollllccc::;;;,,,,''''''''...';cccccccc:';llllllllllcccc::::::::::::::::::::::::::::::::::::;;:;'';c;........................'''''...
MMMMMMMMMMMMMMMMOldOOOkkkd'.......'''''''...'.....'''..':lllllllcccc::;;,,,,,,,,'''''',,,,,,;;;;:ccccccccc:';llllllllcccccc:cc::::::::::::::::::::::::::::::::;;;,.,cc,............................'....
MMMMMMMMMMMMMMMNdlkOOOOkko..'....''''''............''....:c:::::::::::::::ccccccccccccllllcclllllcccccccccc,,cllllllcccccc:cc:::::::::::::::::::::::::::::::;;;,'':l:'........................''........
MMMMMMMMMMMMMMMOldOOOOOkkl..''.''''''.......'''.....'....:oooooooooooolllllllllllllllllllllcllccccccccccccc;,clllcccccc::::cc::::::::::::::::::::::::::::::::;'';ll:.........'..........................
MMMMMMMMMMMMMMWdckOOOkkkOl..'''''..''......''''''........'cooooooooooolllllllllllllllllllllcccccccccccccccc::ccccccccccc::ccc:::c::::::::::::::::::::::::::;,';clc,.....................................
MMMMMMMMMMMMMMXllOOOOOkkOl..'''''..'''......''''......''..,loooooooooolllllllllllccccccccccccccccccccccccccccccccccccccccccccc::::::::::::::::::::::::::::;',col:..................'....................
MMMMMMMMMMMMMM0coOOOOOkkOo'.'''''...'''.......'........''..'cooolllllllllllllllccccccccccccccccccccc::ccccccccccccccccccccccccccc:::::::::::::::::::::::;'':ooc'..................'''...................
MMMMMMMMMMMMMM0coOOOOOkkOx,..''.....''''................'...':oolllllllllllllccccccccccccccccccccccccccccccccccccccccccccc::cccc::::::::::::::::::::::;,';lol,....................'''...................
MMMMMMMMMMMMMM0clOOOOkkkkk:.......''.........................'colc:ccclclllccccccccccccccccccccccccccccccccccccccccccccccc::::::ccccccccc:::::::::::;,';looc'......................''...................
MMMMMMMMMMMMMMXllOOOkkkkkkl'......''.....................'''..'colcc::::cccccccccccccc:ccccccccccccccccccccccccccccccccccccc:::::::::c::::::::::::;,',cooo:............................'................
MMMMMMMMMMMMMMXllOOOkkkkkkx;.............................'''...':loollcccccc::ccccc::ccccllllllllllccccllccccccccccccccccccc::::::::cc::::::::::;,',coool;...................'..........................
MMMMMMMMMMMMMMNocxkkkkkkkkkl.............................'.......;loololllllllllllllllllllllllllllllllllllllccccccccccccc:::::::::::::::::::::;,';codddl,...............................................
MMMMMMMMMMMMMMWxcdkxxxkkkkkx;....................''........''''...;cooooollllooooooollllllllllllllcccclllllcccccccccccccccccc::c::::::::::::;'';looddoc'...................'............................
MMMMMMMMMMMMMMMOcokkkkkkkkkkd,..'........................'''''''.':;:looollooooooooolllllllcc:::ccccccllcclcccccccccccccccccc::c:c::::::::;,,:lddoddo;.....................'............................
MMMMMMMMMMMMMMMXllkkkkkkkkkkkl'..'...................'...'........:o:;coollooooooolllllcccccc:ccclccccccccccccccccccccccccccccc::::::::;,,;coddddddc'.....................''............................
MMMMMMMMMMMMMMMNocxkkkkkkkkkkx:..''....''.'..''.....'''......'....'lxl::cloooooooollllllllllllccclcccccccccccccccccccccccccccc:::::::;',;lddddxxdl,..................'.....'............................
MMMMMMMMMMMMMMMWx:dkkkkkkkkkkko'..'''''''.'''''.............''''''.'okxo:;cloooooooooooooollllccccccccccccccccccccccccccc:::::cc::;,,;cloddddddl,.......................................................
MMMMMMMMMMMMMMMM0clkkkkkkkkxxxxc..''''''.....''............''.......,okkkoc::clooolllllllllllllcccccccccccccccccccccccc::::::::;,,;:lddddddddl;..'......................................................
MMMMMMMMMMMMMMMMNl:xkkkkkkkkkkkx;..''..'.....''.................'''..,okOOkdlc:::;:::cccccccc::;;;;;;;:::::::::ccc:::c:::::;,,;;coddddxxxxxdc'..........................................................
MMMMMMMMMMMMMMMMWx:dkkkkkkkkkkkkl'.''.''''...''...........''...''''''.'lxOkkkkxdolcc::;;'...'',,;;;;;;;:::::::::ccc::::;,,,;:lodxxddxxkkxoc,............................................................
MMMMMMMMMMMMMMMMM0cckkkkkkkkkkkkd,.''.'''''...............''....''''''..;okkkkkkkkxxxxddolcc::;,,,,,;;;;;;;;;;;;;,,,,,;:ccodxdddxxxxxdl:,'..............................................................
MMMMMMMMMMMMMMMMMNd:xOOkkkkkkkkkx;.'''..'''........'...'.''........'''''.';lxkkkkkkkkkxxxxxxxxdllcc:::::::::::::::clloddxddddddxxkdl:,..................................................................
MMMMMMMMMMMMMMMMMM0cokkkkkkkkkkkx:.'''''..''..........'''...........'''''''.,okkOOOkkkkxxxxxddddddddxxxxxxxxdddxxxdddddxdddxxxdoc;'...'''...............................................................
MMMMMMMMMMMMMMMMMMNo:dkkkkkkkxxkx:.'''''''''..........''..............''''''.':dkOOOOOkkxxxxxdxxddxxxxxxxxxxddddxxxxdxxxxdxxdc;'..''...''...............................................................
MMMMMMMMMMMMMMMMMMMKclkkkkkkkkkkx;.'''''''''...........................''''''''':okkkOOOkkkkxxxkkxkxxxxxxxxxxxxxxxxxxxkkkxo:'..''.......................................................................
MMMMMMMMMMMMMMMMMMMWkcdOOOkkkkkkx;.''...'''''........................''''''''','.';cdkOOkkkkkkkkkkkkkkkkkxxkkkkkkkkxkkkko:'.'''.........................................................................
MMMMMMMMMMMMMMMMMMMMNockOOkkOkkkk:.''....'''.......................''''''.''''''''..':okkkkkkkkkOOOOOOOOkkOOkkkkkkkxkkd:'.''..'.........................................................................
MMMMMMMMMMMMMMMMMMMMM0loOOkkOkkkkc.''....''......'........'''....'''''.....'''''''''...;ldxkOOOOOOOOOOOOOOOOOOkkOkkxdc'..'..................'...........................................................
MMMMMMMMMMMMMMMMMMMMMWxcxOkkkkkkko'.'''''''................''.....'''........'..''''''...,okkOOOOOOOOOkkOOOOOOkkOOko,...................................................................................
MMMMMMMMMMMMMMMMMMMMMMXllkOkkkOkOx;.'''....'''''.......''...''....''''..'.........'''.....'cdkOOOOOOOOOOOOOOOkdlc:;.....................................................................................
MMMMMMMMMMMMMMMMMMMMMMWkcxOkkkkkOOo,...''.''''......''''.........''''''.....'............'..'cxOOOOOOOOOOkdl:,....................''''..................................................................
MMMMMMMMMMMMMMMMMMMMMMMKloOkOOOkkkkc'..'''''........'''.............'''.....''................';:ccccc::;'........................'',,'.................................................................
MMMMMMMMMMMMMMMMMMMMMMMXooOkkOkkkkkx;..''.............'.............''....''''..........................................................................................................................
MMMMMMMMMMMMMMMMMMMMMMMNdokkkOkkkkkOo'.'''............'............''.....'''''.'''''.............................''''''''...''.........................................................................

*/
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Logger.log(">>> Aplicación iniciada.");

        Scanner entrada = new Scanner(System.in);
        GestorConfiguracion gestor = new GestorConfiguracion();
        LectorRSS lector = new LectorRSS();

        System.out.println("Iniciando asistente...");
        String urlActual = gestor.cargarConfig();

        if (urlActual == null) {
            System.err.println("Error crítico: No se pudo cargar la configuración. Saliendo.");
            return;
        }

        int opcion = -1;

        do {
            System.out.println("\n--- ASISTENTE DIGITAL DE NOTICIAS ---");
            System.out.println("1. Actualizar noticias desde el feed");
            System.out.println("3. Ver/Modificar URL del feed");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Conectando al feed: " + urlActual + "...");

                    Logger.log("Iniciando lectura del feed: " + urlActual);

                    List<Noticia> noticiasLeidas = lector.parseFeed(urlActual);

                    if (noticiasLeidas == null || noticiasLeidas.isEmpty()) {
                        System.out.println("No se han encontrado noticias o hubo un error.");
                        Logger.log("No se encontraron noticias o hubo error al leer: " + urlActual);
                    } else {
                        System.out.println("¡Éxito! Se han encontrado " + noticiasLeidas.size() + " noticias.");

                        Logger.log("Lectura exitosa. Se han descargado " + noticiasLeidas.size() + " noticias.");

                        Noticia primeraNoticia = noticiasLeidas.get(0);
                        System.out.println("--- EJEMPLO DE LA PRIMERA NOTICIA ---");
                        System.out.println("Título: " + primeraNoticia.getTitulo());
                        System.out.println("Link: " + primeraNoticia.getLink());
                        System.out.println("Fuente (Autor): " + primeraNoticia.getFuente());
                        System.out.println("Fecha (Long): " + primeraNoticia.getFecha());
                    }
                    break;

                case 3:
                    System.out.println("La URL del feed actual es: " + urlActual);
                    System.out.print("Introduce la nueva URL (deja en blanco para no cambiar): ");

                    String nuevaUrl = entrada.nextLine();

                    if (nuevaUrl != null && !nuevaUrl.trim().isEmpty()) {
                        gestor.guardarConfig(nuevaUrl);

                        Logger.log("URL del feed modificada. Antigua: " + urlActual + " -> Nueva: " + nuevaUrl);

                        urlActual = nuevaUrl;
                        System.out.println("Configuración guardada correctamente.");
                    } else {
                        System.out.println("No se han realizado cambios.");
                    }
                    break;

                case 0:
                    Logger.log("<<< Aplicación finalizada.");
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        } while (opcion != 0);

        entrada.close();
    }
}