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
    
    minTime=0
    scoreBoard=[]
    for name in dicOfTimes:
        fastestLap=0
        previousLap=0
        for lap in dicOfTimes[name]:
            if (lap-previousLap<fastestLap or fastestLap==0):
                fastestLap=lap-previousLap
            previousLap=lap
        if fastestLap<minTime or minTime==0:
            minTime=fastestLap
        scoreBoard.append((name,fastestLap))
    
    
    newSb=list(filter(lambda item:(item[1]==minTime), scoreBoard))
    newSb=[x for x,y in newSb]
    
    return sorted(newSb)