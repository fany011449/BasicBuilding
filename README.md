# 抽象類和接口的差異：

| **比較項目**  | **接口（Interface）**                                         | **抽象類（Abstract Class）**                  |
| --------- | --------------------------------------------------------- | ---------------------------------------- |
| **定義方式**  | 使用 `interface` 關鍵字，所有方法默認為 `public` 且無方法體                 | 使用 `abstract class` 關鍵字，可以有普通方法和抽象方法     |
| **方法**    | 只能有抽象方法（<mark>Java 8</mark> 以後可有 `default` 和 `static` 方法） | 可以有抽象方法和具體方法                             |
| **屬性**    | 只能定義 `public static final` 常量                             | 可以有普通的字段（`private`、`protected`、`public`） |
| **繼承方式**  | 使用 `implements`，可以實現多個接口                                  | 使用 `extends`，只能繼承一個抽象類                   |
| **多重繼承**  | 支持（可以同時實現多個接口）                                            | 不支持（只能繼承一個父類）                            |
| **使用場景**  | 用於定義一組行為約定                                                | 用於提供基礎功能，適合父類與子類關係                       |
| **構造函數**  | 不可以有構造函數                                                  | 可以有構造函數                                  |
| **訪問修飾符** | 方法默認 `public`，不能是 `private` 或 `protected`                 | 可以使用 `private`、`protected` 和 `public`    |

# 關於static修飾：

> <mark>無</mark>static修飾，屬於 <u>對象object </u>擁有的
> <mark>有</mark>static修飾，屬於 <u>類class </u>擁有的

# Collection <E> 集合體系結構：

## 1. List ：有序、可重複、有索引

> - ArrayList
> 
> - LinkedList

### ArrayList

底層是基於 <u>"陣列" </u>儲存 data。

- 特性：

> 1. 查詢 快
> 2. 增刪 慢這是因為陣列是連續記憶體結構，可以透過索引快速查詢，但增刪時需要移動大量元素。

原先預設是給空的數組。

```java
//表示預設情況下建立的是一個空陣列。
DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
```

只有在第一次添加元素時，才會透過 `grow()` 進行擴容：：

```java
return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
```

- `DEFAULT_CAPACITY`預設為 10。

- 第一次加入元素會配置長度為 10 的陣列。

- 當元素數量達到容量上限時，會呼叫 `grow()` 進行擴容。

- 擴容策略為原長度的 1.5 倍，例如：
  
  - 第一次 grow：10 → 15
  
  - 第二次 grow：15 → 22（15 + 7）

### LinkedList

底層是基於<u>"鏈表"</u>存儲data

#### 單鏈表

- 每個節點在記憶體中位置不連續。

- 每個節點包含：
  
  1. 資料值（data）
  
  2. 下一個節點的記憶體位址（next）

【特性】：

1. 搜尋慢：無法直接存取任意元素，需<u>從頭節點</u>開始逐一走訪。

2. 插入/刪除相對快（已知節點位置時）

#### 雙鏈表

- 每個節點在記憶體中位置不連續。

- 每個節點包含：
  
  1. 資料值（data）
  
  2. 下一個節點地址（next）
  
  3. 前一個節點地址（prev）

【特點】：

1. 搜尋仍然慢（線性走訪）

2. 插入/刪除更快（可從尾端反向走訪，或雙向調整鏈接）

※ Java 中的 `LinkedList` 是採用「雙向鍊表」實作。

※ 若用索引進行插入/刪除，仍需線性走訪找到目標節點，因此效率與 `ArrayList` 不一定更優。

## 2. Set： 無序、無重複、無索引

- HashSet
  
  - LinkedHashSet：<mark>有序</mark>、 無重複、無索引

- TreeSet： <mark>按照大小默認升序排序</mark>、無重複、無索引

### HashSet

HashSet = 底層包裝 HashMap

所有元素作為 key，value 使用一個固定的 Object 作為佔位

#### HashMap 底層原理

- JDK 8 以前：
   `HashMap = 陣列 + 鍊表`（LinkedList）
  
  - 新元素直接存入數組，老元素接在鏈表。

- JDK 8 以後：
   `HashMap = 陣列 + 鍊表 + 紅黑樹`（當碰撞嚴重時轉為紅黑樹）
  
  - 新元素接在鏈表。

【特性】：

1. 支援高效的 增、刪、改、查

2. 平均時間複雜度為 O(1)

【流程】：

1. 建立預設大小為 16 的陣列 table，負載因子為 0.75
   => 若元素數量 > 12（16 * 0.75），則擴容為 32 (原先大小的兩倍)

2. 插入元素時：
   a. 使用<u> key </u>的`hashCode()` 經過 hash 函數處理
   b. 對<u>陣列長度</u>取餘（實際使用位元運算）取得` index（bucket）`
   
   `hashCode() %　array.length() = bucket`
   
   c. 若該 bucket 為 null，直接插入
   d. 否則，遍歷 bucket 鍊表或樹：
   
   - 若已有相同 key（equals() 相等），覆蓋 value
   
   - 否則加入新節點（尾部）

3. 若同一 bucket 鍊長 > 8 且 table.length >= 64，則轉為紅黑樹結構

#### 哈希碰撞Hash Collision

使用每個元素的<mark>哈希值</mark>對<mark>數組的長度</mark>做運算計算該放哪個位置

`hashCode() %　table.length() = bucket(索引位置)`

但事實上，HashMap底層原理是利用了<mark>位元運算（bitwise AND）</mark>來實現取餘數%

`hashCode() & (c.length - 1) =bucket(索引位置)`

若<mark>＂索引位置(bucket)＂相同</mark>，此時會發生　<mark><u>＂哈希碰撞(Hash Collision)＂</u></mark>

### LinkedHashSet

- 基於 `HashSet` 實作，因此底層仍是：**`數組 + 鏈表 + 紅黑樹`（JDK 8+）**

【特性】：

- **有序**：保持「插入順序」，靠 **雙向鏈表（Doubly Linked List）** 記錄元素順序

- **無重複**：透過 `hashCode()` + `equals()` 判斷唯一性

- **無索引**：不像 List 可以透過 get(index)

### Set底層原理

- `HashSet` 是基於 `HashMap` 實作的

- `HashMap` 與 `HashSet` 是基於 **哈希表（Hash Table）**

- `LinkedHashSet` 是基於 `LinkedHashMap` 實作的

- `TreeSet` 是基於 `TreeMap` 實作，底層使用**紅黑樹**

# 字符串

- ASCII：只有英文、數字、符號等。占一個字節

- GBK：漢字占2個字節。英文、符號占一個字節

- UTF-8：漢字占3個字節，英文、數字一個字節（常用）

> 解碼與編碼時需要一致，否則就會出現亂碼

# IO流

<table>
        <thead align='center'>
            <tr>
                <th>抽象類</th>
                <th colspan="5" align="center">實現類</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="abstract-class">字節輸入流 InputStream</td>
                <td class="implementation-class">FileInputStream</td>
                <td class="implementation-class">BufferedInputStream</td>
                <td class="implementation-class"></td>
                <td class="implementation-class"></td>
             <td class="implementation-class">DataInputStream</td>
            </tr>
            <tr>
                <td class="abstract-class">字節輸出流 OutputStream</td>
                <td class="implementation-class">FileOutputStream</td>
                <td class="implementation-class">BufferedOutputStream</td>
                <td class="implementation-class"></td>                
                <td class="implementation-class">PrintStream</td>
                <td class="implementation-class">DataOutputStream</td>
            </tr>
            <tr>
                <td class="abstract-class">字符輸入流 Reader</td>
                <td class="implementation-class">FileReader</td>
                <td class="implementation-class">BufferedReader</td>
                <td class="implementation-class">InputStreamReader</td>
                <td class="implementation-class"></td>
                <td class="implementation-class"></td>
            </tr>
            <tr>
                <td class="abstract-class">字符輸出流 Writer</td>
                <td class="implementation-class">FileWriter</td>
                <td class="implementation-class">BufferedWriter</td>
                <td class="implementation-class"></td>
                <td class="implementation-class">PrintWriter</td>
                <td class="implementation-class"></td>
            </tr>
        </tbody>

## Writer字符輸出流的注意事項

- 使用 `FileWriter` 等**字符輸出流**寫出資料後，**必須刷新流或關閉流**，資料才會實際寫入檔案。

### flush()

- **作用**：刷新緩衝區（cache），將尚未寫入的資料寫入檔案。

- **補充**：資料寫入磁碟前，會先暫存在記憶體中的緩衝區中，`flush()` 就是主動把資料「送出去」。

- **特性**：刷新後**可以繼續使用流**。

### close()

- **作用**：關閉流，並**自動執行 `flush()`**。

- **特性**：關閉後**無法再使用該流**，否則會丟出例外。

## 使用時機

| 類型               | 資料類型          | 使用時機                          | 常見子類                                      |
| ---------------- | ------------- | ----------------------------- | ----------------------------------------- |
| **InputStream**  | **位元組（byte）** | 讀「**非文字**」資料（圖片、影片、音訊、檔案copy） | `FileInputStream`、`BufferedInputStream`   |
| **OutputStream** | **位元組（byte）** | 寫「**非文字**」資料（存檔、copy檔案、圖片輸出）  | `FileOutputStream`、`BufferedOutputStream` |
| **Reader**       | **字元（char）**  | 讀「**文字**」資料（.txt 檔、文字檔案）      | `FileReader`、`BufferedReader`             |
| **Writer**       | **字元（char）**  | 寫「**文字**」資料（.txt 寫入、日誌log）    | `FileWriter`、`BufferedWriter`             |

> ✏️「看你要處理的東西是 **文字（文字檔）** 還是 **非文字（二進位檔）**」

- 處理圖片、影片、音樂、壓縮檔 ⇒ `InputStream` / `OutputStream`（byte）

- 處理 `.txt`、`.java`、`.log`、XML、JSON ⇒ `Reader` / `Writer`（char）

## 緩衝字節輸入流BufferedInputStream

**作用：**

- 用來**提升原始輸入流（InputStream）讀取資料的效能**。

- 原本讀一個 byte 會觸發一次 IO 操作，使用緩衝流後，可以**一次性讀取一整塊資料**，減少系統資源開銷（系統調用次數）。

**原理：**

- 內部自帶一個**預設大小為 8KB 的緩衝區（byte[] buffer）**。

- 第一次讀取時會把底層資料來源（如檔案）的內容先讀入緩衝區。

- 後續程式對 `BufferedInputStream` 的讀取操作，會優先從緩衝區拿資料，而不是每次都直接讀磁碟。

- 當緩衝區讀完時，再一次性重新填滿。

> `BufferedInputStream` 提高效能的原理是：透過 8KB 的緩衝區，**減少磁碟的讀取次數**，每次都從記憶體緩衝先取資料，而不是每次都向作業系統請求。

## 緩衝字節輸出流BufferedOutputStream

**先把寫入資料存在緩衝區中，等資料夠多再一次寫入磁碟**，減少頻繁 IO 寫入。

## InputStreamReader

> `InputStreamReader`：把「位元組流 (InputStream)」轉換成「字元流 (Reader)」
> 
> 讓 byte → char，**位元組轉字元**的橋樑

```
[byte 位元組來源，如檔案/鍵盤]
 ↓ InputStream (如 FileInputStream, System.in)
 ↓
 InputStreamReader（轉碼器）
 ↓
 Reader（可用 BufferedReader 包起來使用）
```

## PrintStream

**用途**

- 是字節輸出流（`OutputStream`）的包裝類別。

- 用來輸出字節資料（byte），但它有方便的 **print()** 和 **println()** 方法，可以直接輸出各種基本類型和字串。

- 不會拋出 IOException（異常被捕獲並且不會傳出），使用起來較方便，但錯誤不易捕捉。

- 例如 `System.out` 就是 `PrintStream`，用於標準輸出（console）。

## PrintWriter

**用途**

- 要用於 **字符流（character stream）** 的輸出。

- 是 `Writer` 的子類別，支援更靈活的字符處理。

- 同樣支援自動刷新緩衝區（需手動啟用）。

**兩者相同的常用方法：**

```java
print(), println(), printf(), format()
```

**總結**

| 特點              | PrintStream      | PrintWriter |
| --------------- | ---------------- | ----------- |
| 輸出類型            | 位元組流 (byte)      | 字元流 (char)  |
| 是否拋 IOException | 不會               | 會           |
| 常見用途            | 標準輸出、簡單輸出        | 需要字符編碼和錯誤處理 |
| 編碼支持            | 不直接支持（Java 10 前） | 支援（可指定字符集）  |

## DataInputStream（資料輸入串流）

- 繼承自 `FilterInputStream`

- 讓你可以從輸入串流中讀取「**結構化的基本型別資料**」

- 常配合 `FileInputStream` 使用

**常用方法：**

```java
int i = dis.readInt();
double d = dis.readDouble();
String s = dis.readUTF();
```

## DataOutputStream（資料輸出串流）

- 繼承自 `FilterOutputStream`

- 讓你可以將「**基本型別資料**」以二進位格式寫入串流中

- 常配合 `FileOutputStream` 使用

**常用方法：**

```java
dos.writeInt(123);
dos.writeDouble(3.14);
dos.writeUTF("Hello");
```

【線程安全問題】
當有一個共享資源（例如一個全域變數、集合物件等），被多個線程讀取修改時，就會產生<mark>"線程安全問題"</mark>。

【處理方法有三種】

1. 同步代碼塊（Synchronized Block）
   
   - 使用 `synchronized` 關鍵字鎖住某個物件，僅允許一個線程進入該區塊。
   
   - 語法較靈活，適合只針對部分程式碼加鎖。

```java
synchronized (鎖物件) {
    // 需要同步的程式碼
}
```

2. 同步方法（Synchronized Method）
   
   - 在方法上加 `synchronized`，相當於整個方法加鎖。
   
   - 鎖的是當前物件（或類別本身，若是 static 方法）。

```java
public synchronized void example() {
    // 同步執行的程式碼
}
```

3. Lock鎖
   
   - 提供比 `synchronized` 更靈活的鎖機制。
   
   - 需手動加鎖和解鎖。

```java
Lock lock = new ReentrantLock();
lock.lock();
try {
    // 受保護的程式碼
} finally {
    lock.unlock(); // 務必釋放鎖
}
```

# 線程池ThreadPoolExecutor

```java
ThreadPoolExecutor executor = new ThreadPoolExecutor(
    corePoolSize,
    maximumPoolSize,
    keepAliveTime,
    unit,
    workQueue,
    threadFactory,
    handler
);
```

| 參數                | 說明                                                                             |
| ----------------- | ------------------------------------------------------------------------------ |
| `corePoolSize`    | 核心線程數量。線程池啟動後，會預先建立這些**核心線程**，即使空閒也不會釋放。                                       |
| `maximumPoolSize` | 最大線程數量。當任務過多、隊列已滿時，會建立**臨時線程**（最大值 = 此值）。`臨時線程：maximumPoolSize - corePoolSize` |
| `keepAliveTime`   | 臨時線程的最大空閒存活時間（超過時間未被使用就會被銷毀）。                                                  |
| `unit`            | `keepAliveTime` 的時間單位(秒、分、時、天)，如：`TimeUnit.SECONDS`、`MINUTES` 等。               |
| `workQueue`       | 任務排隊隊列。常見如：`LinkedBlockingQueue`、`ArrayBlockingQueue`。                         |
| `threadFactory`   | 線程工廠，用來創建新線程。可自定義線程名稱、是否為守護線程等。                                                |
| `handler`         | 拒絕策略，當任務無法處理時的應對方式，如：`AbortPolicy`、`CallerRunsPolicy` 等。                       |

## 小提醒

- 常見工作隊列：
  
  - `LinkedBlockingQueue`（無界）
  
  - `ArrayBlockingQueue`（有界）

- 常見拒絕策略（`RejectedExecutionHandler`）：
  
  - `AbortPolicy`：直接丟異常（預設）
  
  - `CallerRunsPolicy`：交由呼叫者執行
  
  - `DiscardPolicy`：默默丟棄
  
  - `DiscardOldestPolicy`：丟掉最舊的排隊任務

## 臨時線程的創建時機點

當新任務提交時，**若同時符合以下三個條件**，ThreadPoolExecutor 會創建臨時線程來處理任務：

1. **核心線程已全部忙碌**（已達 `corePoolSize`）。

2. **任務隊列已滿**（`workQueue` 滿了）。

3. **目前線程總數 < maximumPoolSize**（尚可創建臨時線程）。

➡️ 此時會創建「臨時線程」來處理任務。這些臨時線程在空閒超過 `keepAliveTime` 後會被銷毀。

## ThreadPoolExecutor的主要線程數

| 任務類型        | 說明               | 線程數量配置建議                                                           |
| ----------- | ---------------- | ------------------------------------------------------------------ |
| **CPU 密集型** | 任務主要耗費 CPU 計算資源  | `corePoolSize = CPU 核心數``maximumPoolSize = corePoolSize + 1`       |
| **IO 密集型**  | 任務主要等待 IO（磁碟/網路） | `corePoolSize = CPU 核心數``maximumPoolSize = corePoolSize × (2 ~ 5)` |

### 說明補充：

- **CPU 密集型任務**：如大量數學運算、影像壓縮、加密解密等，應避免開過多線程，否則會產生頻繁的上下文切換。

- **IO 密集型任務**：如資料庫存取、網頁抓取、檔案讀寫等，線程經常處於等待狀態，因此可適當增加線程數提升吞吐量。

- 可透過 `Runtime.getRuntime().availableProcessors()` 獲取 CPU 核心數。

【併發(Concurrent/並行(Parallel)】
併發 ： 一個CPU輪番切換處理多個線程，切換快速
並行 ： 同時間處理多個線程
多線程：併發與併行同時進行

# 併發（Concurrency） vs 並行（Parallelism）

| 概念                   | 說明                                                                                             |
| -------------------- | ---------------------------------------------------------------------------------------------- |
| **併發 (Concurrency)** | 一個 CPU 同時處理多個任務的「假象」，實際上是透過 **時間片輪轉（Thread switching）** 快速切換不同任務，使它們看起來同時在執行。📌 單核 CPU 也可實現併發。 |
| **並行 (Parallelism)** | 多個任務 **真正同時執行**，必須有 **多核 CPU** 支援，將不同任務分配給不同核心同時處理。📌 多核 CPU 可實現並行處理。                          |

# 多線程

- **多線程（Multithreading）** 是一種技術，用來同時執行多個任務（Thread）。

- 在實際執行中，它**可能是併發，也可能是並行，甚至是兩者混合**：
  
  - 單核 → 併發（模擬同時）
  
  - 多核 → 並行（真正同時）

# 通信協議

## UDP（User Datagram Protocol，用戶資料報協議）

- 特點：
  
  - ✅ 無需建立連接，直接傳送封包。
  
  - ✅ 每個封包中包含源IP/端口與目標IP/端口等資訊。
  
  - ✅ 通訊速度快，但不保證數據送達與順序。

- 優點：
  
  - 傳輸效率高、延遲低。

- 缺點：
  
  - 不保證數據可靠性，可能丟包或順序錯亂。

- 應用場景：
  
  - 🎥 視訊直播、🎧 語音通話、🎮 線上遊戲。

## TCP（Transmission Control Protocol，傳輸控制協議）

- 特點：
  
  - ✅ 面向連接的協議，資料傳送前需先建立連線。
  
  - ✅ 提供可靠的數據傳輸（順序、有確認、有重傳）。
  
  - ✅ 支援全雙工通訊（雙方可同時收發）。

- 優點：
  
  - 傳輸可靠，資料完整性高。

- 缺點：
  
  - 建立與關閉連接需額外耗費時間與資源，效率較低。

- 應用場景：
  
  - 🌐 網頁請求、📥 文件下載、💰 線上支付。

### TCP 三次握手（Three-Way Handshake）

建立連接的流程如下：

```java
Client ---------------------> Server
         (1) 發出連接請求 SYN(Synchronize)

Client <--------------------- Server
         (2) 同意連接，回應 SYN + ACK(Acknowledgment)

Client ---------------------> Server
         (3) 客戶端再次確認 ACK，建立連線完成
```

### TCP 四次揮手（Four-Way Handshake）

斷開連接的流程如下：

```java
Client ---------------------> Server
         (1) 發出斷開連接請求 FIN(Finish)

Client <--------------------- Server
         (2) Server 回應 ACK（先確認）

Client <--------------------- Server
         (3) Server 再發出自己的斷開請求 FIN

Client ---------------------> Server
         (4) Client 回應 ACK，斷開完成
```

# Exception的分類

| Exception 類型        | 編譯期檢查            | 是否強制處理                | 常見例子                                                            |
| ------------------- | ---------------- | --------------------- | --------------------------------------------------------------- |
| Checked Exception   | 是 (compile-time) | 必須 try-catch 或 throws | IOException、SQLException（檔案不存在、網路中斷）                            |
| Unchecked Exception | 否 (runtime-time) | 可選擇處理                 | NullPointerException、ArithmeticException（除以零、陣列越界、null pointer） |

# Annotation 註解

**定義：**

Annotation 是 Java 提供的一種「**元資料（Metadata）機制**」，用來對程式中的類別、方法、欄位等加上**額外的說明或訊息**，而不影響實際邏輯。



**常見用途：**

| 類型      | 用途                                                |
| ------- | ------------------------------------------------- |
| 編譯提示    | 如 `@Override`, `@Deprecated`, `@SuppressWarnings` |
| 反射 + 處理 | 自訂註解（如 `@MyAnnotation`）＋反射處理邏輯                    |
| 框架控制    | 如 Spring 的 `@Autowired`, `@Controller`            |
| 測試      | 如 JUnit 的 `@Test`、`@Before`                       |

```java
 // 1. 獲取類的對象
        Class c1 = demo.class;

        Method m1 = c1.getMethod("go");
        // 2. 判斷類裡面是否有MyTest的註解
        if(m1.isAnnotationPresent(MyTest.class)) {
            // 3. 獲取註解的對象
            MyTest myTest = m1.getDeclaredAnnotation(MyTest.class);

            // 4. 既可獲取其屬性
            String value = myTest.value();
            double price = myTest.price();
            String[] address = myTest.address();

            System.out.println(value);
            System.out.println(price);
            System.out.println(Arrays.toString(address));
        }
```





## 元註解

### Target

```java
// 只能註解在 方法、成員變量、構造器
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
```

**常見 ElementType：**

1. TYPE — 類、接口

2. FIELD — 成員變量

3. METHOD — 成員方法

4. PARAMETER — 方法參數

5. CONSTRUCTOR — 構造器

6. LOCAL_VARIABLE — 局部變量

### Retention

```java
@Retention(RetentionPolicy.RUNTIME) // 編譯器運行時(一直都存在)
```

**RetentionPolicy 類型：**

1. SOURCE — 註解只存在原始碼，編譯後即消失（幾乎不用）

2. CLASS — 註解會存在 class 檔案，但執行時不可見（默認值）

3. RUNTIME — 註解會存在 class 並且執行時可透過反射讀取（通常使用這個）



## 暴力反射 + 註解 = 框架魔法

> 很多框架就是掃描類別上的註解，再透過反射操作對應成員。

例如 Spring 會這樣做：

1. 掃描類別是否有 `@Controller`

2. 掃描欄位是否有 `@Autowired`

3. 用暴力反射注入 bean（物件）









# Refection 反射機制

**定義：**

- Java 的反射機制允許在執行時動態取得類別的結構與成員（欄位、方法、建構子）並進行操作。

**暴力反射：**

- 用於繞過 `private/protected` 權限限制，直接存取或修改成員。

**範例：**

```java
 // 1. 取得類對象
        Class c2 = Student.class;

        // 2. 獲取構造器對象
        // 有Declared就是只要構造器存在就能拿來用
        Constructor[] constructors = c2.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "(" + constructor.getParameterCount() + ")");
        }

        // 3. 獲取單個構造器
        Constructor constructor = c2.getDeclaredConstructor();
        System.out.println(constructor.getName() + "(" + constructor.getParameterCount() + ")");

        Constructor constructor1 = c2.getDeclaredConstructor(String.class, int.class); // 後面接的是參數的意思
        System.out.println(constructor1.getName() + "(" + constructor1.getParameterCount() + ")");

        // 4. 獲取構造器的作用依然是創建對象
        // 【暴力反射】：可以訪問私有的構造器、方法、屬性
        constructor.setAccessible(true); // 繞過權限，可以直接訪問私有private
        Student s1 = (Student) constructor.newInstance();
        System.out.println(s1);
```



# Java Proxy（代理）

## 什麼是 Proxy？

Proxy（代理）是一種設計模式，用來建立一個「**中介物件**」，控制對某個物件的訪問。Java 中的代理常用來在方法呼叫前後加上「**額外邏輯**」，例如：

- 日誌記錄
- 權限驗證
- 方法執行時間統計
- 交易控制（如 Spring 的 @Transactional）

這種「切入方法邏輯的外層」就是 AOP（Aspect-Oriented Programming）的核心思想。

---

## Java 中的代理類型

| 類型       | 說明                     | 限制                     |
| -------- | ---------------------- | ---------------------- |
| 靜態代理     | 自己手寫代理類別               | 重複性高、每個業務類都要寫一次        |
| 動態代理     | 使用 Java `Proxy` 在執行時生成 | 只能代理「介面」               |
| CGLIB 代理 | 使用第三方工具代理類別本身          | 需要額外依賴、無法代理 final 類與方法 |

---

## 動態代理原理（Java 原生 Proxy）

1. 實作 `InvocationHandler` 介面
2. 呼叫 `Proxy.newProxyInstance(...)` 生成代理物件
   1. 參數一：`類.class.getClassLoader`
   2. 參數二：`取得你類所有的interface`
   3. 重寫`InvocationHandler()`裡的`invoke`方法，裡面放你多個重複的代碼塊
3. 使用時呼叫的方法會轉給 `invoke(...)` 處理

---

程式碼範例

```java
// 使用泛型<T>就能夠通用所有對象進來做代理
    public static <T> T createProxy(T t){
        T proxy = (T) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                t.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start =  System.currentTimeMillis();
                        Object result = method.invoke(t, args);
                        long end =  System.currentTimeMillis();
                        System.out.println(method.getName() + "方法耗時：" + (end - start) / 1000.0 + "秒");
                        return result;
                    }
                });
        return proxy;
    }
```
