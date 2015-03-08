using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmAnalysisExample2
{
    class Program
    {
        static int[] sortCalculation(int[] array) 
        {
            int len = array.Length;
            int temp;
            for (int i = 0; i < len; i++)
            {
                for (int j = i + 1; j < len; j++)
                {
                    if (array[j] > array[i])
                    {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
            return array;
        }

        static int sortCalculationWithRange(int[] array, int range)
        {
            int len = array.Length;
            int temp;
            for (int i = 0; i < range; i++)
            {
                for (int j = i + 1; j < len; j++)
                {
                    if (array[j] > array[i])
                    {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
            return array[range-1];
        }

        static int getMaxElement(int[] arr) 
        {
            int[] newArr = sortCalculation(arr);
            return newArr[0]; // Max eleman 
        }

        static void showValuesOfArray(int[] arr) 
        {
            int len =  arr.Length;
            String output ="arr : ";
            for (int i = 0; i <len; i++)
            {
                output += arr[i].ToString()+" ";
            }
            Console.WriteLine(output);
        }

        static void options(int[] dizi) 
        {
            Console.WriteLine("\n Diziyi siralamak isterseniz : 1\n Sıralamada istediğiniz sıradaki elemanı öğrenmek için :2\n "+
            "Max eleman için : 3 \n Herhangi bir index elemani ogrenmek icin : 4   \n Cikis icin 1 , 2 , 3, 4 haricinde bir tusa basiniz ");
            int opt = Int32.Parse(Console.ReadLine());
            if (opt == 1)
            {
                Console.WriteLine("Dizinin sirali hali : ");
                sortCalculation(dizi);
                showValuesOfArray(dizi);
                options(dizi);
            }
            else if (opt == 2)
            {
                Console.WriteLine("Kaçıcı sıradaki büyük olan sayiyi istiyorsun :");
                int k = Int32.Parse(Console.ReadLine());
                Console.Write("Dizinin önceki hali : ");
                showValuesOfArray(dizi);
                Console.Write("Istedigin eleman : {0} \n", sortCalculationWithRange(dizi, k));
                Console.WriteLine("Dizinin istedigin elemanı bulmak icin sıralanmis hali : ");
                showValuesOfArray(dizi);
                Console.WriteLine();
                options(dizi);
            }
            else if(opt == 3)
            {
                Console.WriteLine("Maximum buyuklukteki eleman : {0} \n",getMaxElement(dizi));
                options(dizi);
            }
            else if (opt == 4)
            {
                Console.WriteLine("Dizinin herhangi bir indexteki elemani icin index degeri girin : ");
                int k = Int32.Parse(Console.ReadLine());
                Console.Write("Dizinin durumu : ");
                showValuesOfArray(dizi);
                Console.WriteLine("Istedigidiniz eleman : {0}",dizi[k-1]);
            }
        }
        static void Main(string[] args)
        {
            int[] dizi = { 9,5,2,2,6,8,10,-2};
            options(dizi);
            Console.ReadKey();
        }
    }
}
