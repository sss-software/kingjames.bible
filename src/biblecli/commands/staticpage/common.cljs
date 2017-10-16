;;;;   Copyright 2017 Peter Stephens. All Rights Reserved.
;;;;
;;;;   Licensed under the Apache License, Version 2.0 (the "License");
;;;;   you may not use this file except in compliance with the License.
;;;;   You may obtain a copy of the License at
;;;;
;;;;       http://www.apache.org/licenses/LICENSE-2.0
;;;;
;;;;   Unless required by applicable law or agreed to in writing, software
;;;;   distributed under the License is distributed on an "AS IS" BASIS,
;;;;   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
;;;;   See the License for the specific language governing permissions and
;;;;   limitations under the License.

(ns biblecli.commands.staticpage.common
  (:require [clojure.string :as s]
            [common.bible.model :as model]))

(def book-names {:Genesis        "Genesis"
                 :Exodus         "Exodus"
                 :Leviticus      "Leviticus"
                 :Numbers        "Numbers"
                 :Deuteronomy    "Deuteronomy"
                 :Joshua         "Joshua"
                 :Judges         "Judges"
                 :Ruth           "Ruth"
                 :Samuel1        "I Samuel"
                 :Samuel2        "II Samuel"
                 :Kings1         "I Kings"
                 :Kings2         "II Kings"
                 :Chronicles1    "I Chronicles"
                 :Chronicles2    "II Chronicles"
                 :Ezra           "Ezra"
                 :Nehemiah       "Nehemiah"
                 :Esther         "Esther"
                 :Job            "Job"
                 :Psalms         "Psalms"
                 :Proverbs       "Proverbs"
                 :Ecclesiastes   "Ecclesiastes"
                 :SongOfSolomon  "Song of Solomon"
                 :Isaiah         "Isaiah"
                 :Jeremiah       "Jeremiah"
                 :Lamentations   "Lamentations"
                 :Ezekiel        "Ezekiel"
                 :Daniel         "Daniel"
                 :Hosea          "Hosea"
                 :Joel           "Joel"
                 :Amos           "Amos"
                 :Obadiah        "Obadiah"
                 :Jonah          "Jonah"
                 :Micah          "Micah"
                 :Nahum          "Nahum"
                 :Habakkuk       "Habakkuk"
                 :Zephaniah      "Zephaniah"
                 :Haggai         "Haggai"
                 :Zechariah      "Zechariah"
                 :Malachi        "Malachi"
                 :Matthew        "Matthew"
                 :Mark           "Mark"
                 :Luke           "Luke"
                 :John           "John"
                 :Acts           "Acts"
                 :Romans         "Romans"
                 :Corinthians1   "I Corinthians"
                 :Corinthians2   "II Corinthians"
                 :Galatians      "Galatians"
                 :Ephesians      "Ephesians"
                 :Philippians    "Philippians"
                 :Colossians     "Colossians"
                 :Thessalonians1 "I Thessalonians"
                 :Thessalonians2 "II Thessalonians"
                 :Timothy1       "I Timothy"
                 :Timothy2       "II Timothy"
                 :Titus          "Titus"
                 :Philemon       "Philemon"
                 :Hebrews        "Hebrews"
                 :James          "James"
                 :Peter1         "I Peter"
                 :Peter2         "II Peter"
                 :John1          "I John"
                 :John2          "II John"
                 :John3          "III John"
                 :Jude           "Jude"
                 :Revelation     "Revelation"})

(defn book-name [bookId] (get book-names bookId))

(defn book-name-nbsp [book-id]
  (let [name (book-name book-id)]
    (s/replace name #"^(I|II|III)\s+" "$1&nbsp;")))

(defn book-elem-id [book-id]
  (s/replace (book-name book-id) " " "-"))

; TODO: implement as part of book chapter index
;(defn book-url [book]
;  )

(defn chapter-name
  ([bookId chapterNum chapterCount]
   (if (> chapterCount 1)
     (str (book-name bookId) " " chapterNum)
     (book-name bookId)))
  ([{bookId ::model/bookId
     chapterNum ::model/chapterNum
     chapterCount ::model/chapterCount}]
   (chapter-name bookId chapterNum chapterCount)))

(defn chapter-url
  ([bookId chapterNum chapterCount]
   (s/replace (chapter-name bookId chapterNum chapterCount) " " "-"))
  ([{bookId ::model/bookId
     chapterNum ::model/chapterNum
     chapterCount ::model/chapterCount}]
   (chapter-url bookId chapterNum chapterCount)))

