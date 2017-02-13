# pol
Implementação de pol, linguagem de policy de segurança e privacidade

<h1> Policy Language </h1>

Implementation of the pol language, a language of security and privacy policies

<h2> Pol setup </h2>

<h3> I - Installing ANTLR Plugin </h3>

<ol>
<li>  -  Download and install the eclipse IDE </li>
<li>  -  Setup your workspace where you cloned the pol repository</li>
<li>Install XText 2.7.3
<ol>
  <li>Go to <code>Help &gt; Install New Software...</code></li>
  <li>Enter <code>http://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/</code> in the <code>Work With</code>     textbox</li>
  <li>Hit Enter and wait for the list to load (this will take a few moments)</li>
  <li>Expand the <code>Xtext</code> node and check <code>Xtext Complete SDK</code> (ensure the version is 2.7.3x)</li>
  <li>Click <code>Next</code>, agree to the EULA, and click finish</li>
  <li>Let the installer finish and restart Eclipse</li>
</ol>
</li>
<li>Install ANTLR 4 IDE
<ol>
  <li>Go to <code>Help &gt; Eclipse Marketplace...</code></li>
  <li>Search for <code>antlr</code></li>
  <li>Choose <code>ANTLR 4 IDE</code> (make sure it's ANTLR 4 IDE not ANTLR IDE)</li>
  <li>Click Install</li>
  <li>Let the installer finish clicking ok if it prompts and restart Eclipse</li>
</ol>
</li>
</ol>

<h3>II - Creating an ANTLR Project in Eclipse </h3>
  <ol>
  <li> Go to <code>File > New Project > Project</code></li>
  <li> Select folder General > Select ANTLR 4 Project</li>
  <li> Next > Put the project name "PolicyLanguage" > Finish</li>
  <li> Right click on <code>Pol.g4</code> > <code>Run as...</code> > <code>External tools configuration</code></li>
  <li> Paste this on the arguments <code>-no-listener -visitor -encoding UTF-8</code></li>
  <li> Run the PoL.g4 </li>
  </ol>

<h3>III - Create the Policy Language Core Project</h3>
<ol>
  <li> <code> Go to File > New Project > Java Project </code></li>
  <li> <code> Next > Put the project name "PolicyLanguageCore" > Finish</code></li>
  <li> Right Click on Project > Configure > Convert to Maven Project </li>
  </ol>

<h3>IV - Run the Policy Language ore Project</h3>
<ol>
<li> Next > Put the project name "PolicyLanguageCore" > Finish</li>
<li> Right Click on Project > Configure > Convert to Maven Project</li>
<li> Copy all the files of <code> PolicyLanguage > target > generated-resources > antlr </code> except <code> PoLBaseVisitor.java </code> to <code> PolicyLanguageCore > src > structure</code></li>
<li> Put your file path as argument when running the <code>PolicyBuilder.java</code> in <code> Run Configurations </code> </li>
<li>Run the project</li>
</ol>
  


  
 
