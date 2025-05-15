# ***<u>重點筆記：</u>***

抽象類和接口的差異：  

    相同點：  
        1. 都是抽象形式，都可以有抽象方法，都無法創建對象。  
        2. 都是子類形式：  抽象類 是被 子類 繼承使用  
                          接口 是被 實現類 實現。  
        3. 一個類 繼承 抽象類 or 實現接口，都必須重寫完他們的抽象方法，
            否則自己要成為抽象類 or 報錯  
        4. 都能支持多態，都能實現解耦合  
    
    不同點：  
        1. 抽象類 中能定義全部成員  
            接口  只能定義常量、抽象方法(JDK8新增的三種方法)  
        2. 抽象類  只能被類單繼承  
            接口   可以被多個類實現  
        3. 抽象類  適用於模板設計(Design Pattern)，更利於做父類，實現代碼的複用性  
            接口   適用於做功能的解耦合，模組性更強  

關於static修飾：  
    無static修飾，屬於 對象object 擁有的  
    有static修飾，屬於 類class 擁有的  

抽象類和接口的使用時機：  
    抽象類：  
        無法創建對象，所以只能被繼承，用來做為父類，實現代碼的重複性。  
    接口：  
        無法創建對象，所以使用匿名內部類，可以創建一個接口的實現類，當作一個子類來使用。  

Collection <E> 集合體系結構：  
    1. List ：有序、可重複、有索引  
        ArrayList  
        LinkedList    2. Set： 無序、無重複、無索引  
        HashSet  
            LinkedHashSet："有序" 、 無重複、無索引  
        TreeSet："按照大小默認升序排序"、無重複、無索引  

【ArrayList】  底層是基於"數組"存儲data  
    【特性】：  
        1. 查詢 快  
        2. 增刪 慢  
     => 原先預設是給空的數組。DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};  
     => 是第一次添加data後，才會藉由grow()擴容。  
        return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];  
        由於DEFAULT_CAPACITY是10, 所以返回會是10作為數組的Size。  
     => 當元素到11索引時，會進行第二次grow()。此時數組長度會從10 -> 15。成長1.5倍  
     => 同理索引16，長度會是 15+ (15 >> 1) = 15 + 7 = 22  

【LinkedList】 底層是基於"鏈表"存儲data  
    【單鏈表】  
        => 節點在內存中是不連續的，每個節點包含的'數據值'和'下一個節點的地址'  
        【特性】：  
            1. 查詢 慢 ; 無論查詢哪個數據，都需要從頭開始查詢  
            2. 增刪 相對快  
    【雙鏈表】  
        => 節點在內存中是不連續的，每個節點包含的'數據值'和'下一個節點的地址'和'前一個節點的地址'  
        【特點】：  
            1. 查詢 慢  
            2. 增刪 相對快。 對(首尾的元素) 增刪改查 是極快的  

【哈希表ＨａｓｈＴａｂｌｅ】  
    ＪＤＫ８ before ，哈希表　＝　數組　＋　鏈表  
    ＪＤＫ８ after ，哈希表 ＝　數組　＋　鏈表　＋　紅黑樹  
    哈希表是一種　＂增刪改查　＂，性能較好的數據結構  

     【步驟】  
     1. 創建一個默認長度１６的數組，默認加載因子為０.７５，數組名table  
        （與ArrayList相同，也是第一次添加元素後擴容）  
        （１６　＊　０.７５　＝　１２。當元素１２格填滿後，繼續往後擴容，大小會變為原先的兩倍，１６ －＞　３２）  
    
     2. 使用每個元素的　＂哈希值＂ 對　＂數組的長度＂做運算計算該放哪個位置  
        => hashCode() %　array.length() = bucket(索引位置)  
     （哈希值：在ＪＡＶＡ中的對象，每個都有一個哈希值）  
        注意! 但這邊計算"索引位置(bucket)"是由Key的HashCode()。  
     （若＂索引位置(bucket)＂相同，此時會發生　＂哈希碰撞(Hash Collision)＂）  
    
     3. 判斷當前位置是否ｎｕｌｌ，  
        如果是ｎｕｌｌ，則直接存入。  
        反之，表示該位置存在元素，則要調equals()來確認元素是否兩者相同，  
        相同，則不存入。  
        不相同，存入。  
        【ＪＤＫ８　before 存入數組中鏈表的方式】  
            新元素直接存入數組，老元素接在鏈表。  
    
        【ＪＤＫ８　After 存入數組中鏈表的方式】  
            新元素接在鏈表。  
        ( 鏈結長度 > 8 || 數組長度 >= 64 ，則鏈結自動轉成　＂紅黑樹　＂)  

【LinkedHashSet】  
    依舊是照著 ＂數組　＋　鏈表　＋　紅黑樹　＂。但要注意！　這邊是　＂有序　＂、　無重複　、　無索引。  
    ＂有序　＂的原因就是因為是使用【雙鏈表】來記錄前、後節點。  

【底層原理】  
    實際上：Set集合就是由Map實現的，只是Set集合中的元素只要key值。  
        HashMap與HashSet的底層原理相同，都是基於HashTable實現。  
        TreeSet與TreeMap的底層原理相同，都是基於紅黑樹實現。  
        LinkedHashMap的底層原理，都是基於LinkedHashSet  

【字符串】  
    ASCII：只有英文、數字、符號等。占一個字節  
    GBK：漢字占2個字節。英文、符號占一個字節  
    UTF-8：漢字占3個字節，英文、數字一個字節（常用）  

    => 解碼與編碼時需要一致，否則就會出現亂碼  

【IO流】  
              【抽象類】          【實現類】  
    字節輸入流 InputStream       FileInputStream     BufferedInputStream                                         DataInputStream  
    字節輸出流 OutputStream      FileOutputStream    BufferedOutputStream                        PrintStream     DataOutputStream  
    字符輸入流 Reader            FileReader          BufferedReader          InputStreamReader  
    字符輸出流 Writer            FileWriter          BufferedWriter                              PrintWriter  

【Writer字符輸出流的注意事項】  
    字符輸出流FileWriter寫出數據後必須刷新流，或關閉流。寫出的數據才能生效  
        flush() 。刷新cache，將還在cache的data寫入文件。刷新後能繼續使用流  
                    <因為寫入disk之前後先有個暫存cache收集data，之後才會一次性寫入>  
        close() 。關閉包含了flush()，關閉後無法繼續使用流  

【使用時機】  
Question: 什麼時候用字節流，什麼時候用字符流  
Answer:  
        字節流：copy的時候  
        字符流：讀寫文本的時候  

【緩衝字節輸入流BufferedInputStream】  
作用：可以提高InputStream讀取數據的性能，因為減少了系統調用。  
原理：自帶 8KB 緩衝池，緩衝字節輸出流也是  

【線程安全問題】  
當有一個共享資源，被多個線程讀取修改時，就會產生"線程安全問題"  

【處理方法有三種】  

1. 同步代碼塊  
2. 同步方法  
3. lock鎖  

【線程池ThreadPoolExecutor的參數說明】  

1. corePoolSize：線程池的核心線程數量  
2. maximumPoolSize：指定線程池的最大線程數量  
   臨時工：maximumPoolSize - corePoolSize  
3. keepAliveTime：指定臨時線程的存活時間  
4. unit：指定臨時線程存活的時間單位(秒、分、時、天)  
5. workQueue：指定線程池的任務隊列  
6. threadFactory：指定線程池的線程工廠 (主要生成線程)  
7. handler：指定線程池的任務拒絕策略 (主要返回異常)  

【臨時線程的創建時機點】  
新任務提交時，發現核心線程Busying，且任務隊列也滿了，並且還可以創建臨時線程，此時既可創建。  

【ThreadPoolExecutor的主要線程數】  
corePoolSize：電腦CPU數  
會分成兩種：  
    1. CPU密集型任務  
        => 用於計算類型的Code  
        maximumPoolSize：corePoolSize + 1  
    2. IO 密集型任務  
        => 用於磁盤讀寫、網路請求  
        maximumPoolSize：corePoolSize * (2 ~ 5)  

【併發(Concurrent/並行(Parallel)】  
併發 ： 一個CPU輪番切換處理多個線程，切換快速  
並行 ： 同時間處理多個線程  
多線程：併發與併行同時進行  

【通信協議】  
    UDP (User Datagram Protocol)：用戶數據報協議  
        => 客戶端、伺服器沒事前建立連接，一整包數據丟過去(自己IP、端口、目的地IP、...)  
        優點：通信效率高  
        缺點：因無連接，數據丟失也不管，故不可靠  
        e.g. 視訊直播、語音通話  

    TCP (Transmission Control Protocol)：傳輸控制協議  
        => 面向連接，可靠通信。  
        => TCP主要三個步驟實現"可靠傳輸"  
        優點：可靠信高  
        缺點：通信效率不佳，因為端方一來一往  
        e.g. 網頁、文件下載、支付  
        (可靠傳輸：確保通信雙方傳收信息都沒問題，俗稱"全雙工")  
        1. 三次握手建立連結  
        2. 傳輸數據進行確認  
        3. 四次揮手斷開連結  
    
        【三次握手】  
        Client -------------> Sever  
               (發出連接請求)  
               <-------------               (返回一個響應)  
               ------------->          (再次發出消息確認信息，建立連結)  
    
        【四次揮手】  
        Client -------------> Sever  
               (發出斷開連結請求)  
               <-------------               (返回一個響應：稍等)  
               <-------------               (返回一個響應：確認斷開)  
               ------------->               (發出確認斷開消息，確認斷開)  

### 

### 【Exception的分類】

| 類型                                     | 編譯期檢查 | 是否強制處理                | 常見例子                                                                  |
| -------------------------------------- | ----- | --------------------- | --------------------------------------------------------------------- |
| Checked Exception<br/>(compile-time)   | 是     | 必須 try-catch 或 throws | IOException、SQLException<br/>(檔案不存在、網路中斷)                             |
| UnChecked Exception<br/>(Runtime-time) | 否     | 可選擇處理                 | NullPointerException, ArithmeticException<br/>(除以零、陣列越界、null pointer) |

# 【元註解】

## Target

```java
// 只能註解在 方法、成員變量、構造器
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
```



> 1. TYPE 類、接口
> 
> 2. FIELD 成員變量
> 
> 3. METHOD 成員方法
> 
> 4. PARAMETER 方法參數
> 
> 5. CONSTRUCTOR 構造器
> 
> 6. LOCAL_VARIABLE 局部變量

## Retention

```java
@Retention(RetentionPolicy.RUNTIME) // 編譯器運行時(一直都存在)
```



> 1. SOURCE (幾乎不用)
> 
> 2. CLASS (默認值)
> 
> 3. RUNTIME (通常都是用這個)
