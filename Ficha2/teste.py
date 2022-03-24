"""

Implemente uma função que, dada uma lista com registos de instantes de tempo e nome de piloto, 
descrevendo os tempos de passagem pela meta dos varios pilotos numa corrida de F1, 
devolva a lista com os nomes dos pilotos com a volta mais rápida ordenada por ordem alfabética. 
Assuma que todos os pilotos iniciaram a prova no instante 0.

"""

def formula1(log):
    dicOfTimes={}
    for time,name in log:
        if name not in dicOfTimes:
            dicOfTimes[name]=[time]
        else:
            dicOfTimes[name].append(time)
    loggerFinal=[]
    
    for name in dicOfTimes:
        fastestLap=dicOfTimes[name][0]
        previousLap=0
        for lap in dicOfTimes[name]:
            if (lap-previousLap<fastestLap):
                fastestLap=lap-previousLap
            previousLap=lap
        loggerFinal.append((name,fastestLap))
    
    _,minTime=min(loggerFinal,key=lambda item:item[1])
    
    best=[]
    
    for name,time in loggerFinal:
        if time==minTime:
            best.append(name)
    
    return sorted(best)