file = open(raw_input('File to adfasdf: '),'r')
changed = open(raw_input('Changed file name: '),'w')
code = file.read()

code = code.replace('int ','i')

newstuff = 'asdfsa'

changed.write(newstuff)
changed.close()
file.close()

