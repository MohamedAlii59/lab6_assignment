<h1>Autosar File Sorting Tool</h1>

### Student Name: Mohamed Ali Fadl    
### ID: 2000965   
### Section: 3 (CSE) 

<p>This is a Java program that sorts the <code>&lt;CONTAINER&gt;</code> elements in an Autosar file based on their UUIDs and writes the sorted elements to a new Autosar file. The program takes the file name as a command line argument and checks if the file is a valid Autosar file before proceeding with sorting.</p>
<h2>Usage</h2>
<p>To use the program, navigate to the directory containing the program and run the following command in the terminal:</p>
<pre><code>java Main &lt;filename.arxml&gt;
</code></pre>
<p>Replace <code>&lt;filename.arxml&gt;</code> with the name of the Autosar file you want to sort.</p>
<p>The program will create a new Autosar file in the same directory with the name <code>&lt;filename&gt;_mod.arxml</code>.</p>
<h2>Exceptions</h2>
<p>The program throws three types of exceptions:</p>
<ul>
<li><code>NotVaildAutosarFileException</code>: thrown when the input file is not a valid Autosar file.</li>
<li><code>FileNotFoundException</code>: thrown when the input file is not found.</li>
<li><code>IOException</code>: thrown when there is an I/O exception.</li>
</ul>
