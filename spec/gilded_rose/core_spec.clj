(ns gilded-rose.core-spec
(:require [speclj.core :refer :all]
          [gilded-rose.core :refer [update-quality item]]))

(describe "canary test"
  (it "the framework should work"
       (should true)))

(defn pass-days [n inventory]
  (nth (iterate update-quality inventory) n))

(let [
        sulfuras [(item "Sulfuras, Hand of Ragnaros" 0 80)]
        passed-item [(item "passed item" 0 10)]
      ]
(describe "gilded rose"
  (it "should not affect legendary items"
       (should= sulfuras (pass-days 1 sulfuras)))
  (it "Once the sell by date has passed, quality degrades twice as fast"
       (should= [(item "+5 Dexterity Vest" 9 9)] (pass-days 1 [(item "+5 Dexterity Vest" 10 10)]))
       (should= [(item "+5 Dexterity Vest" -2 8)] (pass-days 1 [(item "+5 Dexterity Vest" -1 10)]))
       (should= [(item "+5 Dexterity Vest" -3 6)] (pass-days 2 [(item "+5 Dexterity Vest" -1 10)]))
      )
))
