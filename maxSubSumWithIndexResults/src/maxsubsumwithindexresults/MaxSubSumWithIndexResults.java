package maxsubsumwithindexresults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class MaxSubSumWithIndexResults {

    static private int seqStart = 0;
    static private int seqEnd = -1;

    static Map<ArrayList,Integer> map = new HashMap<ArrayList, Integer>();   // ArrayList'te indexler tutulacak, Integer olarak maxSubSum tutulacak. 
    static ArrayList<Integer> arrList = new ArrayList<Integer>();
    /**
     * Cubic maximum contiguous subsequence sum algorithm.
     * seqStart and seqEnd represent the actual best sequence.
     */
    public static Map maxSubSum1( int [ ] a )
    {
        int maxSum = 0;
        map.clear();        //static değişkenler oldugu için clear edilmeli
        arrList.clear();    //static değişkenler oldugu için clear edilmeli
        for( int i = 0; i < a.length; i++ )
            for( int j = i; j < a.length; j++ )
            {
                int thisSum = 0;

                int k=0;
                for(k = i; k <= j; k++ )
                    thisSum += a[ k ];

                if( thisSum > maxSum )
                {
                    arrList.add(k-1);
                    maxSum   = thisSum;
                    seqStart = i;
                    seqEnd   = j;
                }
            }
        map.put(arrList, maxSum);
        return map;
    }

    /**
     * Quadratic maximum contiguous subsequence sum algorithm.
     * seqStart and seqEnd represent the actual best sequence.
     */
    public static Map maxSubSum2( int [ ] a )
    {
        int maxSum = 0;
        int j =0;
        map.clear();
        arrList.clear();
        for( int i = 0; i < a.length; i++ )
        {
            int thisSum = 0;
            for( j = i; j < a.length; j++ )
            {
                thisSum += a[ j ];

                if( thisSum > maxSum )
                {
                    arrList.add(j);
                    maxSum = thisSum;
                    seqStart = i;
                    seqEnd   = j;
                }
            }
        }
        map.put(arrList, maxSum);
        return map;
    }

    /**
     * Linear-time maximum contiguous subsequence sum algorithm.
     * seqStart and seqEnd represent the actual best sequence.
     */
    public static Map maxSubSum4( int [ ] a )
    {
        int maxSum = 0;
        int thisSum = 0;
        map.clear();
        arrList.clear();
        
        for( int i = 0, j = 0; j < a.length; j++ )
        {
            thisSum += a[ j ];

            if( thisSum > maxSum )
            {
                arrList.add(j);
                maxSum = thisSum;
                seqStart = i;
                seqEnd   = j;
            }
            else if( thisSum < 0 )
            {
                i = j + 1;
                thisSum = 0;
            }
        }
        map.put(arrList, maxSum);
        return map;
    }


    /**
     * Recursive maximum contiguous subsequence sum algorithm.
     * Finds maximum sum in subarray spanning a[left..right].
     * Does not attempt to maintain actual best sequence.
     */
    private static int maxSumRec( int [ ] a, int left, int right )
    {
        int maxLeftBorderSum = 0, maxRightBorderSum = 0;
        int leftBorderSum = 0, rightBorderSum = 0;
        int center = ( left + right ) / 2;

        if( left == right )  // Base case
            return a[ left ] > 0 ? a[ left ] : 0;

        int maxLeftSum  = maxSumRec( a, left, center );
        int maxRightSum = maxSumRec( a, center + 1, right );

        for( int i = center; i >= left; i-- )
        {
            leftBorderSum += a[ i ];
            if( leftBorderSum > maxLeftBorderSum ){
                maxLeftBorderSum = leftBorderSum;
            }
        }

        for( int i = center + 1; i <= right; i++ )
        {
            rightBorderSum += a[ i ];
            if( rightBorderSum > maxRightBorderSum ){
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3( maxLeftSum, maxRightSum,
                     maxLeftBorderSum + maxRightBorderSum );
    }

    /**
     * Return maximum of three integers.
     */
    private static int max3( int a, int b, int c )
    {
        return a > b ? a > c ? a : c : b > c ? b : c;
    }

    /**
     * Driver for divide-and-conquer maximum contiguous
     * subsequence sum algorithm.
     */
    public static int maxSubSum3( int [ ] a )
    {
        return a.length > 0 ? maxSumRec( a, 0, a.length - 1 ) : 0;
    }

    public static void getTimingInfo( int n, int alg )
    {
        int [] test = new int[ n ];

        long startTime = System.currentTimeMillis( );;
        long totalTime = 0;

        int i;
        for( i = 0; totalTime < 4000; i++ )
        {
            for( int j = 0; j < test.length; j++ )
                test[ j ] = rand.nextInt( 100 ) - 50;

            switch( alg )
            {
              case 1:
                maxSubSum1( test );
                break;
              case 2:
                maxSubSum2( test );
                break;
              case 3:
                maxSubSum3( test );
                break;
              case 4:
                maxSubSum4( test );
                break;
            }

            totalTime = System.currentTimeMillis( ) - startTime;
        }

        System.out.print( String.format( "\t%12.6f", ( totalTime * 1000 / i ) / (double) 1000000 ) );
    } 
    
    private static Random rand = new Random( );
    
    /**
     * Simple test program.
     */
    public static void main( String [ ] args )
    {
        int a[ ] = { 4, -3, 5, -2, -1, 2, 6, -2 };
        int maxSum;
        Map<ArrayList,Integer> m = null; 
        m = maxSubSum1( a );
        
        
        for(Map.Entry<ArrayList,Integer> entry : m.entrySet())
        {
            System.out.println("MaxSubSum of maxSubSum1 : " + entry.getValue() +" Indexes :"+entry.getKey());
        }
        
        
        m = maxSubSum2( a );
        
        
        for(Map.Entry<ArrayList,Integer> entry : m.entrySet())
        {
            System.out.println("MaxSubSum of maxSubSum2 : " + entry.getValue() +" Indexes :"+entry.getKey());
        }
        
        maxSum = maxSubSum3( a );
        System.out.println( "Max sum is " + maxSum );
        
        
        m = maxSubSum4( a );
        
        
        for(Map.Entry<ArrayList,Integer> entry : m.entrySet())
        {
            System.out.println("MaxSubSum of maxSubSum4 : " + entry.getValue() +" Indexes :"+entry.getKey());
        }
        
      
          // Get some timing info
        for( int n = 100; n <= 1000000; n *= 10 )
        {
            System.out.print( String.format( "N = %7d" , n ) );
            
            for( int alg = 1; alg <= 4; alg++ )
            {
                if( alg == 1 && n > 50000 )
                {
                    System.out.print( "\t      NA    " );
                    continue;
                }
                getTimingInfo( n, alg );
            }
            
            System.out.println( );
        }
    }
    
}
