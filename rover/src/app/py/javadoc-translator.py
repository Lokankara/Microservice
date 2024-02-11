from pathlib import Path
import re
from googletrans import Translator
import time

def translate_text(text, target_language='uk', max_retries=5):
    for _ in range(max_retries):
        try:
            translator = Translator()
            translation = translator.translate(text, dest=target_language)
            return translation.text
        except Exception as e:
            print(f"Error during translation: {e}")
            time.sleep(2)

    print(f"Translation failed after {max_retries} retries. Skipping translation.")
    return text

def extract_javadoc_comments(file_content):
    pattern = r'/\*\*(?s:(?!\*/).)*\*/'
    javadoc_comments = re.findall(pattern, file_content)
    return javadoc_comments

def translate_javadoc_comments(file_path):
    with open(file_path, 'r', encoding='utf-8') as file:
        content = file.read()

    javadoc_comments = extract_javadoc_comments(content)

    for comment in javadoc_comments:
        translated_comment = translate_text(comment)
        content = content.replace(comment, translated_comment, 1)

    with open(file_path, 'w', encoding='utf-8') as file:
        file.write(content)

def process_java_files(directory):
    java_files = [file for file in Path(directory).rglob('*.java')]

    return java_files

def main():
    base_directory = r"e:\app\worker\executor-service\src\main\java\executor\service"
    
    java_files = process_java_files(base_directory)

    for file_path in java_files:
        print(f"{file_path.name}")

        translate_javadoc_comments(file_path)

    print("\nTranslation completed.")

if __name__ == "__main__":
    main()
