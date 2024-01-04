class Player(var name: String, var surName: String)
{
    var totalScore = 0
    var personalBestScore = 0
    
    fun fullName(): String
    {
        return name + " " + surName
    }
          
}
    
    
class Scores() 
{
    fun checkBest (best: Int, current: Int) : Int
    {
        if (best < current)
        {
            return current
        }
        return best
        
    }
    
}


fun main() 
{
    val P1 = Player("Nicola", "Tesla")
    val P2 = Player("Thomas", "Edison")
    val scoring = Scores()
    var lvlScore = 0
    
    lvlScore = 12
    P1.totalScore += lvlScore
    P1.personalBestScore = scoring.checkBest(P1.personalBestScore, lvlScore)
    
    lvlScore = 34
    P2.totalScore += lvlScore
    P2.personalBestScore = scoring.checkBest(P2.personalBestScore, lvlScore)
    
    lvlScore = 56
    P1.totalScore += lvlScore
    P1.personalBestScore = scoring.checkBest(P1.personalBestScore,lvlScore)
    
    lvlScore = 99
    P1.totalScore += lvlScore
    P1.personalBestScore = scoring.checkBest(P1.personalBestScore,lvlScore)
    
    lvlScore = 10
    P2.totalScore += lvlScore
    P2.personalBestScore = scoring.checkBest(P2.personalBestScore,lvlScore)
    
    if(P1.totalScore > P2.totalScore)
    {
        println("The winner is " + P1.fullName() + " with a Score of " + P1.totalScore)
        
        println("Personal Best Score is = " + P1.personalBestScore)
    }
    else
    {
        println("the Winnder is " + P2.fullName() + " with a score of " + P2.totalScore)
                println("Personal Best Score is = " + P2.personalBestScore)

    }
    }
    
  
