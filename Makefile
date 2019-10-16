export MODEL_BASENAME=tidyup
export REPO_NAME=tidy-up
export GITHUB_ORGANIZATION=kode-konveyor
export SONAR_ORG=$(GITHUB_ORGANIZATION)
export LANGUAGE=java

include /usr/local/toolchain/rules.java

shippable/tidyup-testcases.xml:
	zenta-xslt-runner -xsl:xslt/generate_test_cases.xslt -s tidyup.richescape modelbasename=tidyup reponame=tidy-up github_org=kode-konveyor 
